package com.company.creditapplication.screen.offer;

import com.company.creditapplication.entity.Client;
import com.company.creditapplication.entity.Credit;
import com.company.creditapplication.screen.client.ClientEdit;
import io.jmix.core.DataManager;
import io.jmix.ui.Dialogs;
import io.jmix.ui.Notifications;
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

import java.util.Collection;
import java.util.UUID;

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


    @Subscribe("createBtn")
    public void onCreateBtnClick(Button.ClickEvent event) {
        dialogs.createOptionDialog()
                .withCaption("Пожалуйста подтвердите")
                .withMessage("Зарегистрирован ли клиент?")
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

        Offer singleSelected = offersTable.getSingleSelected();
        Credit credit = dataManager.create(Credit.class);
        credit.setIsActive(true);
        credit.setAmount(singleSelected.getAmount());
        credit.setNumberMounth(singleSelected.getNumberMonths());
        credit.setPercent(singleSelected.getPercent());
        singleSelected.setCredit(credit);
        Offer save = dataManager.save(singleSelected);
        Credit credit1 = save.getCredit();

        screenBuilders.editor(Credit.class, this)
                .editEntity(credit1)
                .build()
                .show();
    }

    @Subscribe(id = "offersDc", target = Target.DATA_CONTAINER)
    public void onOffersDcItemChange(InstanceContainer.ItemChangeEvent<Offer> event) {
        Offer singleSelected = offersTable.getSingleSelected();
        if (singleSelected.getCredit() == null) {
            editBtn.setEnabled(true);
            removeBtn.setEnabled(true);
            generateCredit.setEnabled(true);
        } else {
            editBtn.setEnabled(false);
            removeBtn.setEnabled(false);
            generateCredit.setEnabled(false);
        }
    }
}