package com.company.creditapplication.security;

import com.company.creditapplication.dto.PassportDto;
import com.company.creditapplication.entity.*;
import io.jmix.security.model.EntityAttributePolicyAction;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.EntityAttributePolicy;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;
import io.jmix.security.role.annotation.SpecificPolicy;
import io.jmix.securityui.role.annotation.MenuPolicy;
import io.jmix.securityui.role.annotation.ScreenPolicy;

@ResourceRole(name = "ManagerResourceRole", code = "manager-resource-role")
public interface ManagerResourceRole {
    @MenuPolicy(menuIds = {"cap_Bank.browse", "cap_Client.browse", "cap_Credit.browse", "cap_CreditProgram.browse", "cap_Offer.browse", "cap_PassportDto.browse"})
    @ScreenPolicy(screenIds = {"cap_Bank.browse", "cap_Client.browse", "cap_Credit.browse", "cap_CreditProgram.browse", "cap_Offer.browse", "cap_PassportDto.browse", "bulkEditorWindow", "ui_LayoutAnalyzerScreen", "singleFileUploadDialog", "ui_AddConditionScreen", "ui_JpqlFilterCondition.edit", "ui_PropertyFilterCondition.edit", "ui_GroupFilterCondition.edit", "ui_FilterConfigurationModel.fragment", "ui_MBeanInspectScreen", "ui_MBeanAttribute.edit", "ui_MBeanOperationResultScreen", "ui_MBeanOperationFragment", "notFoundScreen", "inputDialog", "selectValueDialog", "backgroundWorkProgressScreen", "ui_DateIntervalDialog", "ui_UiDataFilterConfigurationModel.fragment", "sec_RoleFilterFragment", "sec_ResourceRoleModel.lookup", "sec_ResourceRoleModel.edit", "sec_RowLevelRoleModel.edit", "sec_RowLevelRoleModel.lookup", "ResetPasswordDialog", "ChangePasswordDialog", "sec_ScreenResourcePolicyModel.edit", "sec_MenuResourcePolicyModel.edit", "sec_ScreenResourcePolicyModel.create", "sec_MenuResourcePolicyModel.create", "sec_EntityResourcePolicyModel.create", "sec_EntityAttributeResourcePolicyModel.create", "sec_EntityAttributeResourcePolicyModel.edit", "sec_GraphQLResourcePolicyModel.edit", "sec_EntityResourcePolicyModel.edit", "sec_ResourcePolicyModel.edit", "sec_SpecificResourcePolicyModel.edit", "sec_RoleAssignmentScreen", "sec_RoleAssignmentFragment", "sec_RowLevelPolicyModel.edit", "sec_UserSubstitutionEntity.edit", "sec_UserSubstitutionsFragment", "sec_UserSubstitutionsScreen", "entityInfoWindow", "entityInspector.edit", "cap_Bank.edit", "cap_MainScreen", "cap_LoginScreen", "cap_Offer.edit", "cap_Client.edit", "cap_CreditProgram.edit", "cap_PassportDto.edit"})
    void screens();

    @SpecificPolicy(resources = {"ui.bulkEdit.enabled", "ui.filter.modifyConfiguration", "ui.loginToUi", "ui.filter.modifyGlobalConfiguration", "ui.presentations.global", "ui.filter.modifyJpqlCondition", "datatools.ui.showEntityInfo"})
    void specific();

    @EntityAttributePolicy(entityClass = Bank.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Bank.class, actions = EntityPolicyAction.ALL)
    void bank();

    @EntityAttributePolicy(entityClass = Client.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Client.class, actions = EntityPolicyAction.ALL)
    void client();

    @EntityAttributePolicy(entityClass = Credit.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Credit.class, actions = EntityPolicyAction.ALL)
    void credit();

    @EntityAttributePolicy(entityClass = BaseEntity.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = BaseEntity.class, actions = EntityPolicyAction.ALL)
    void baseEntity();

    @EntityAttributePolicy(entityClass = PassportDto.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = PassportDto.class, actions = EntityPolicyAction.ALL)
    void passportDto();

    @EntityAttributePolicy(entityClass = CreditProgram.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = CreditProgram.class, actions = EntityPolicyAction.ALL)
    void creditProgram();

    @EntityAttributePolicy(entityClass = Offer.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Offer.class, actions = EntityPolicyAction.ALL)
    void offer();

    @EntityAttributePolicy(entityClass = PaymentShedule.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = PaymentShedule.class, actions = EntityPolicyAction.ALL)
    void paymentShedule();
}