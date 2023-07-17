package com.company.creditapplication.screen.credit;

import io.jmix.ui.screen.*;
import com.company.creditapplication.entity.Credit;

@UiController("cap_Credit.edit")
@UiDescriptor("credit-edit.xml")
@EditedEntityContainer("creditDc")
public class CreditEdit extends StandardEditor<Credit> {
}