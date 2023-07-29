package com.company.creditapplication.screen.offer;

import com.company.creditapplication.entity.Client;
import com.company.creditapplication.entity.Credit;

import io.jmix.core.DataManager;
import io.jmix.core.Messages;
import io.jmix.ui.Dialogs;
import io.jmix.ui.ScreenBuilders;
import io.jmix.ui.action.Action;
import io.jmix.ui.action.DialogAction;
import io.jmix.ui.component.*;
import io.jmix.ui.model.CollectionLoader;
import io.jmix.ui.model.InstanceContainer;
import io.jmix.ui.screen.*;
import com.company.creditapplication.entity.Offer;
import io.jmix.ui.screen.LookupComponent;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;


@UiController("cap_Offer.browse")
@UiDescriptor("offer-browse.xml")
@LookupComponent("offersTable")
public class OfferBrowse extends StandardLookup<Offer> {
    @Autowired
    private Dialogs dialogs;
    @Autowired
    DataManager dataManager;
    @Autowired
    private ScreenBuilders screenBuilders;
    @Autowired
    private GroupTable<Offer> offersTable;
    @Autowired
    private Button editBtn;
    @Autowired
    private Button removeBtn;
    @Autowired
    private Button generateCredit;
    @Autowired
    private CollectionLoader<Offer> offersDl;
    @Autowired
    Messages messages;


    @Subscribe("createBtn")
    public void onCreateBtnClick(Button.ClickEvent event) {
        dialogs.createOptionDialog()
                .withCaption(messages.getMessage("com.company.creditapplication.screen.offer/offerBrowse.buttonCreateCaption"))
                .withMessage(messages.getMessage("com.company.creditapplication.screen.offer/offerBrowse.buttonCreateMessages"))
                .withActions(
                        new DialogAction(DialogAction.Type.YES, Action.Status.PRIMARY)
                                .withHandler(e -> {
                                    Screen offerEditor = screenBuilders.editor(Offer.class, this)
                                            .newEntity()
                                            .build();

                                    offerEditor.addAfterCloseListener(afterCloseEvent -> offersDl.load());
                                    offerEditor.show();

                                }),
                        new DialogAction(DialogAction.Type.NO)
                                .withHandler(e -> screenBuilders.editor(Client.class, this)
                                        .newEntity()
                                        .build()
                                        .show())
                )
                .show();
    }

    @Subscribe("offersTable.generateCredit")
    public void onOffersTableGenerateCredit(Action.ActionPerformedEvent event) {

        Offer offer = offersTable.getSingleSelected();
        Credit credit = dataManager.create(Credit.class);
        credit.setIsActive(true);
        credit.setAmount(offer.getAmount());
        credit.setNumberMounth(offer.getNumberMonths());
        credit.setPercent(offer.getPercent());
        offer.setCredit(credit);
        offer = dataManager.save(offer);

        screenBuilders.editor(Credit.class, this)
                .editEntity(offer.getCredit())
                .build()
                .show();
    }

    @Subscribe(id = "offersDc", target = Target.DATA_CONTAINER)
    public void onOffersDcItemChange(InstanceContainer.ItemChangeEvent<Offer> event) {
        Offer offer = offersTable.getSingleSelected();
        boolean enable = Objects.nonNull(offer) && Objects.isNull(offer.getCredit());

        editBtn.setEnabled(enable);
        removeBtn.setEnabled(enable);
        generateCredit.setEnabled(enable);
    }
}
