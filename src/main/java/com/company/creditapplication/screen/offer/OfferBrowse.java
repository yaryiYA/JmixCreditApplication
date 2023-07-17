package com.company.creditapplication.screen.offer;

import com.company.creditapplication.entity.Client;
import com.company.creditapplication.screen.client.ClientEdit;
import io.jmix.ui.Dialogs;
import io.jmix.ui.ScreenBuilders;
import io.jmix.ui.action.Action;
import io.jmix.ui.action.DialogAction;
import io.jmix.ui.component.Button;
import io.jmix.ui.screen.*;
import com.company.creditapplication.entity.Offer;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("cap_Offer.browse")
@UiDescriptor("offer-browse.xml")
@LookupComponent("offersTable")
public class OfferBrowse extends StandardLookup<Offer> {
    @Autowired
    private Dialogs dialogs;
    @Autowired
    private ScreenBuilders screenBuilders;



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

}