package com.company.creditapplication.screen.client;

import com.company.creditapplication.dto.PassportDto;
import com.company.creditapplication.webclient.ClientPass;
import io.jmix.core.DataManager;
import io.jmix.core.LoadContext;
import io.jmix.ui.component.EntityPicker;
import io.jmix.ui.component.HasValue;
import io.jmix.ui.component.ScrollBoxLayout;
import io.jmix.ui.component.TextField;
import io.jmix.ui.model.InstanceContainer;
import io.jmix.ui.screen.*;
import com.company.creditapplication.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("cap_Client.edit")
@UiDescriptor("client-edit.xml")
@EditedEntityContainer("clientDc")
public class ClientEdit extends StandardEditor<Client> {
    @Autowired
    protected ClientPass clientPass;
    @Autowired
    protected DataManager dataManager;
    @Autowired
    private EntityPicker<PassportDto> passportDtoField;
    @Autowired
    private TextField<String> firstNameFieldPass;
    @Autowired
    private TextField<String> lastNameFieldPass;
    @Autowired
    private TextField<String> surnameFieldPass;
    @Autowired
    private TextField<String> serialPassportFieldPass;
    @Autowired
    private TextField<String> numberPassportFieldPass;
    @Autowired
    private ScrollBoxLayout scrollPass;


    @Subscribe("passportDtoField")
    public void onPassportDtoFieldValueChange(HasValue.ValueChangeEvent<PassportDto> event) {
        PassportDto value = passportDtoField.getValue();
        getEditedEntity().setPassportID(value.getId());
    }

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {

        if (getEditedEntity().getPassportDto() != null) {
            passportDtoField.setVisible(false);
            scrollPass.setVisible(true);
            PassportDto passportDto = getEditedEntity().getPassportDto();
            firstNameFieldPass.setValue(passportDto.getFirstName());
            lastNameFieldPass.setValue(passportDto.getLastName());
            surnameFieldPass.setValue(passportDto.getSurname());
            serialPassportFieldPass.setValue(String.valueOf(passportDto.getSerialPassport()));
            numberPassportFieldPass.setValue(String.valueOf(passportDto.getNumberPassport()));
        } else {
            scrollPass.setVisible(false);
            passportDtoField.setVisible(true);
        }
    }

    @Install(to = "passportDtoLoader", target = Target.DATA_LOADER)
    private Client passportDtoLoaderLoadDelegate(LoadContext<Client> loadContext) {
        Client editedEntity = getEditedEntity();
        if (getEditedEntity().getPassportID() != null) {
            editedEntity.setPassportDto(clientPass.findByUUID(editedEntity.getPassportID()));
        }
        return editedEntity;

    }


}

