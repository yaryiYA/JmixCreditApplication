package com.company.creditapplication.screen.creditprogram;

import io.jmix.ui.screen.*;
import com.company.creditapplication.entity.CreditProgram;

@UiController("cap_CreditProgram.browse")
@UiDescriptor("credit-program-browse.xml")
@LookupComponent("creditProgramsTable")
public class CreditProgramBrowse extends StandardLookup<CreditProgram> {
}