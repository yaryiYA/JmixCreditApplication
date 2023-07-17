package com.company.creditapplication.screen.paymentshedule;

import io.jmix.ui.screen.*;
import com.company.creditapplication.entity.PaymentShedule;

@UiController("cap_PaymentShedule.edit")
@UiDescriptor("payment-shedule-edit.xml")
@EditedEntityContainer("paymentSheduleDc")
public class PaymentSheduleEdit extends StandardEditor<PaymentShedule> {
}