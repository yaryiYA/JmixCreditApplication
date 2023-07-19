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
    private ScreenBuilders screenBuilders;

    @Autowired
    private Notifications notifications;
    @Autowired
    private Button generateCredit;
    @Autowired
    private GroupTable<Offer> offersTable;




    @Subscribe("createBtn")
    public void onCreateBtnClick(Button.ClickEvent event) {
        dialogs.createOptionDialog()
                .withCaption("Пожалуйста подтвердите")
                .withMessage("Зарегистрирован ли клиент?")
                .withActions(
                        new DialogAction(DialogAction.Type.YES, Action.Status.PRIMARY)
                                .withHandler(e -> screenBuilders.editor(Offer.class, this)
                                        .newEntity()
                                        .build()
                                        .show()),
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


        screenBuilders.editor(Credit.class, this)
                .newEntity()
                .withInitializer(credit -> {
                    credit.setIsActive(true);
                    credit.setPercent(singleSelected.getPercent());
                    credit.setAmount(singleSelected.getAmount());
                    credit.setNumberMounth(singleSelected.getNumberMonths());
                    singleSelected.setCredit(credit);
                })
                .build()
                .show();




    }

//    private Credit createCredit(Credit credit,Offer offer) {
//
//        Credit neWcredit = dataManager.create(Credit.class);
//        credit.setId(UUID.randomUUID());
//        credit.setIsActive(true);
//        credit.setAmount(offer.getAmount());
//        credit.setPercent(offer.getPercent());
//        credit.setNumberMounth(offer.getNumberMonths());
//
//        offer.setCredit(neWcredit);
//        return neWcredit;
//    }


}