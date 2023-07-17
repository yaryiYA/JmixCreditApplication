package com.company.creditapplication.screen.creditprogram;

import io.jmix.ui.screen.*;
import com.company.creditapplication.entity.CreditProgram;

@UiController("cap_CreditProgram.edit")
@UiDescriptor("credit-program-edit.xml")
@EditedEntityContainer("creditProgramDc")
public class CreditProgramEdit extends StandardEditor<CreditProgram> {
}