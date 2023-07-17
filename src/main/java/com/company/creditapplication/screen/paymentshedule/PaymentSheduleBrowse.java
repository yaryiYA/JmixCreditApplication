package com.company.creditapplication.screen.paymentshedule;

import io.jmix.ui.screen.*;
import com.company.creditapplication.entity.PaymentShedule;

@UiController("cap_PaymentShedule.browse")
@UiDescriptor("payment-shedule-browse.xml")
@LookupComponent("paymentShedulesTable")
public class PaymentSheduleBrowse extends StandardLookup<PaymentShedule> {
}