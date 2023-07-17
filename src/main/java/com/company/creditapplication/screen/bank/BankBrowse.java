package com.company.creditapplication.screen.bank;

import io.jmix.ui.screen.*;
import com.company.creditapplication.entity.Bank;

@UiController("cap_Bank.browse")
@UiDescriptor("bank-browse.xml")
@LookupComponent("banksTable")
public class BankBrowse extends StandardLookup<Bank> {
}