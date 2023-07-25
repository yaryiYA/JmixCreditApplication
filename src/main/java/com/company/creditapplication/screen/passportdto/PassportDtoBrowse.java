package com.company.creditapplication.screen.passportdto;

import com.company.creditapplication.webclient.ClientPass;
import io.jmix.core.LoadContext;
import io.jmix.ui.screen.*;
import com.company.creditapplication.dto.PassportDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;

@UiController("cap_PassportDto.browse")
@UiDescriptor("passport-dto-browse.xml")
@LookupComponent("passportDtoesTable")
public class PassportDtoBrowse extends StandardLookup<PassportDto> {

    @Autowired
    ClientPass clientPass;

    @Install(to = "passportDtoesDl", target = Target.DATA_LOADER)
    private List<PassportDto> passportDtoesDlLoadDelegate(LoadContext<PassportDto> loadContext) {
        List<PassportDto> all =  clientPass.findAll();
        if(all.isEmpty()) {
            return Collections.emptyList();
        } else {
            return all;
        }
    }
}