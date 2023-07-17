package com.company.creditapplication.screen.client;

import io.jmix.ui.screen.*;
import com.company.creditapplication.entity.Client;

@UiController("cap_Client.edit")
@UiDescriptor("client-edit.xml")
@EditedEntityContainer("clientDc")
public class ClientEdit extends StandardEditor<Client> {
}