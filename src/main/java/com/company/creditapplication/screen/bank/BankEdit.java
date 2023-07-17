package com.company.creditapplication.screen.bank;

import io.jmix.ui.screen.*;
import com.company.creditapplication.entity.Bank;

@UiController("cap_Bank.edit")
@UiDescriptor("bank-edit.xml")
@EditedEntityContainer("bankDc")
public class BankEdit extends StandardEditor<Bank> {
}