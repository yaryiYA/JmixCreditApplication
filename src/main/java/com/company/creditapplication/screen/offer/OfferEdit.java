package com.company.creditapplication.screen.offer;

import com.company.creditapplication.entity.Bank;
import com.company.creditapplication.entity.CreditProgram;
import com.company.creditapplication.entity.PaymentShedule;
import com.company.creditapplication.service.impl.OfferServiceImpl;
import io.jmix.core.Messages;

import io.jmix.core.SaveContext;
import io.jmix.ui.Notifications;
import io.jmix.ui.component.*;

import io.jmix.ui.model.CollectionPropertyContainer;
import io.jmix.ui.model.InstanceContainer;
import io.jmix.ui.screen.*;
import com.company.creditapplication.entity.Offer;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@UiController("cap_Offer.edit")
@UiDescriptor("offer-edit.xml")
@EditedEntityContainer("offerDc")
public class OfferEdit extends StandardEditor<Offer> {
    @Autowired
    private Validator validator;
    @Autowired
    private EntityPicker<CreditProgram> creditProgramField;
    @Autowired
    protected Messages messages;
    @Autowired
    private OfferServiceImpl offerService;
    @Autowired
    private Notifications notifications;
    @Autowired
    private EntityPicker<Bank> bankField;
    @Autowired
    private CollectionPropertyContainer<PaymentShedule> paymentSheduleDc;

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        creditProgramIsActive();
    }

    @Subscribe("bankField")
    public void onBankFieldValueChange(HasValue.ValueChangeEvent<Bank> event) {
        creditProgramIsActive();
    }


    @Subscribe("percentField")
    public void onPercentFieldValueChange(HasValue.ValueChangeEvent<Double> event) {
        percentFieldValidator(event.getValue());
    }

    @Install(to = "percentField", subject = "validator")
    private void percentFieldValidator(Double value) {

        CreditProgram creditProgram = creditProgramField.getValue();

        Double min = creditProgram.getMinInterestRate();
        Double max = creditProgram.getMaxInterestRate();

        if (value < min || value > max) {
            notifications.create(Notifications.NotificationType.ERROR)
                    .withCaption(messages.getMessage("com.company.creditapplication.screen.offer/offerEdit.messageValidatorCaption"))
                    .withDescription(messages.getMessage("com.company.creditapplication.screen.offer/offerEdit.messageValidatorDescrip"))
                    .show();
            getEditedEntity().setPercent(max);
        }
    }

    private void creditProgramIsActive() {
        creditProgramField.setEditable(!bankField.isEmpty());
    }


    @Install(target = Target.DATA_CONTEXT)
    private Set<Object> commitDelegate(SaveContext saveContext) {
        Offer offer = offerService.saveOfferEntityManager(getEditedEntity());
        Set<Object> offers = new HashSet<>();
        offers.add(offer);
        return offers;
    }

    @Subscribe(id = "offerDc", target = Target.DATA_CONTAINER)
    public void onOfferDcItemPropertyChange(InstanceContainer.ItemPropertyChangeEvent<Offer> event) {
        Set<ConstraintViolation<Offer>> validate = validator.validate(getEditedEntity());
        if (validate.isEmpty() && !"paymentShedule".equals(event.getProperty())) {
            List<PaymentShedule> paymentShedules = offerService.generatePaymentList(getEditedEntity());
            paymentSheduleDc.setItems(paymentShedules);
        }
    }
}















