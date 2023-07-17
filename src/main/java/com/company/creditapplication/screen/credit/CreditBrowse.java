package com.company.creditapplication.screen.credit;

import io.jmix.ui.screen.*;
import com.company.creditapplication.entity.Credit;

@UiController("cap_Credit.browse")
@UiDescriptor("credit-browse.xml")
@LookupComponent("creditsTable")
public class CreditBrowse extends StandardLookup<Credit> {
}