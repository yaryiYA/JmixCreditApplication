package com.company.creditapplication.screen.passportdto;

import com.company.creditapplication.webclient.ClientPass;
import io.jmix.core.LoadContext;
import io.jmix.core.SaveContext;
import io.jmix.ui.screen.*;
import com.company.creditapplication.dto.PassportDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@UiController("cap_PassportDto.edit")
@UiDescriptor("passport-dto-edit.xml")
@EditedEntityContainer("passportDtoDc")
public class PassportDtoEdit extends StandardEditor<PassportDto> {
    @Autowired
    private ClientPass clientPass;

    @Install(to = "passportDtoDl", target = Target.DATA_LOADER)
    private PassportDto passportDtoDlLoadDelegate(LoadContext<PassportDto> loadContext) {
        return getEditedEntity();
    }

    @Install(target = Target.DATA_CONTEXT)
    private Set<Object> commitDelegate(SaveContext saveContext) {
        PassportDto passportDto = clientPass.create(getEditedEntity());
        Set<Object> objects = new HashSet<>();
        objects.add(passportDto);

        return objects;
    }
}