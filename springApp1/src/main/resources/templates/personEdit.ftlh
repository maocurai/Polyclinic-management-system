<#import "parts/common2.ftlh" as c>
<#import "parts/login.ftlh" as l>
<#import "/spring.ftl" as spring/>
<#include "parts/security.ftlh">

<@c.page>

    <div class="py-5 text-center">
        <img class="d-block mx-auto mb-4" src="https://freesvg.org/img/abstract-user-flat-4.png" alt="" width="72" height="72">
        <#if requestType="edit">
            <h2><@spring.message "edit"/> <@spring.message "profile"/></h2>
        <#elseif personType="patient">
            <h2><@spring.message "add.patient"/></h2>
        <#elseif personType="doctor">
            <h2><@spring.message "add.doctor"/></h2>
        </#if>
    </div>

    <div class="col-md-8 order-md-1">
        <h4 class="mb-3"><@spring.message "personal.info"/></h4>
        <#if personType ="patient">
        <form class="needs-validation" action="/patient/update" method="post">
        <#elseif personType ="doctor">
        <form class="needs-validation" action="/doctor/update" method="post">
        </#if>
            <div class="mb-3">
                <label for="username"><@spring.message "name.person"/></label>
                <div class="input-group">
                    <input type="text" class="form-control" minlength="3" maxlength="255" name="fullName" placeholder="${personToEdit.fullName?if_exists}" value="${personToEdit.fullName?if_exists}" required>
                        <div class="invalid-feedback" style="width: 100%;">
                            Your username is required.
                        </div>
                </div>
            </div>
            <div class="mb-4">
                    <label for="email">Email</label>
                    <input type="email" class="form-control" name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" placeholder="${personToEdit.personalInformation?if_exists.email?if_exists}" value="${personToEdit.personalInformation?if_exists.email?if_exists}" required>
                        <div class="invalid-feedback">
                            Please enter a valid email address for shipping updates.
                        </div>
            </div>
            <div class="mb-4">
                <label for="dateOfBirth"><@spring.message "date.of.birth"/></label>
                <#assign aDateTime = .now>
                <#assign aDate = aDateTime?date>
                <input type="date" min="1900-01-01" max="${aDate?iso_utc}" class="form-control" name="dateOfBirth" placeholder="${personToEdit.personalInformation?if_exists.dateOfBirth?if_exists}" value="${personToEdit.personalInformation?if_exists.dateOfBirth?if_exists}" required>
                <div class="invalid-feedback">
                    Please enter a valid email address for shipping updates.
                </div>
            </div>
            <div class="mb-4">
                <label for="phone"><@spring.message "phone.number"/></label>
                <div class="input-group">
                <div class="input-group-prepend">
                    <span class="input-group-text">+38</span>
                </div>
                <input type="tel" pattern="0[1-9]{1}[0-9]{8}" class="form-control" name="phone" placeholder="${personToEdit.personalInformation?if_exists.phone?if_exists}" value="${personToEdit.personalInformation?if_exists.phone?if_exists}" required>
                 <div class="invalid-feedback">
                    Please enter a valid phone.
                </div>
                </div>
                <#if phoneExists??>
                    <div class="row">
                        <label for="phone" style="color: #ff0000;" class="mt-1"><@spring.message "phone.number.is.already.used"/></label>
                    </div>
                </#if>
            </div>
            <hr class="mb-4 mt-4">

            <#if personType ="doctor">
                <div class="mb-3">
                <div class="row">
                        <div class="col-md-5 mb-3">
                            <label for="specialisation"><@spring.message "specialisation"/></label>
                            <select class="custom-select d-block w-100" name="specializationOfDoctorId" required>
                                <option value="${personToEdit.specializationOfDoctor?if_exists.id?if_exists}">${personToEdit.specializationOfDoctor?if_exists.name?if_exists}</option>
                                <#list specialisations as specialisation>
                                    <option value="${specialisation.id}">${specialisation.name}</option>
                                </#list>
                            </select>
                            <div class="invalid-feedback">
                                Please select a valid specialisation.
                            </div>
                        </div>

                        <div class="col-md-5 mb-3">
                            <label for="medicalInstitution"><@spring.message "medical.institution"/></label>
                            <select class="custom-select d-block w-100" name="medicalInstitutionId" required>
                                <option value="${personToEdit.medicalInstitution?if_exists.id?if_exists}">${personToEdit.medicalInstitution?if_exists.name?if_exists}</option>
                                <#list medicalInstitutions as medicalInstitution>
                                    <option value="${medicalInstitution.id}">${medicalInstitution.name}</option>
                                </#list>
                            </select>
                            <div class="invalid-feedback">
                                Please select a valid city.
                            </div>
                        </div>
                </div>
                </div>
            </#if>

            <div class="mb-3">
                <div class="row">
                        <div class="col-md-5 mb-3">
                            <label for="city"><@spring.message "city"/></label>
                            <select class="custom-select d-block w-100" name="cityId" required>
                                <option value="${currentAddress.city?if_exists.id?if_exists}">${currentAddress.city?if_exists.name?if_exists}</option>
                                <#list cities as city>
                                    <option value="${city.id?if_exists}">${city.name?if_exists}</option>
                                    </#list>
                                </select>
                                <div class="invalid-feedback">
                                    Please select a valid city.
                                </div>
                            </div>

                            <div class="col-md-4 mb-3">
                                <label for="region"><@spring.message "region"/></label>
                                <select class="custom-select d-block w-100" name="regionId" required>
                                    <option value="${currentAddress.region?if_exists.id?if_exists}">${currentAddress.region?if_exists.name?if_exists}</option>
                                    <#list regions as region>
                                        <option value="${region.id?if_exists}">${region.name?if_exists}</option>
                                    </#list>
                                </select>
                                <div class="invalid-feedback">
                                    Please provide a valid region.
                                </div>
                            </div>
                            <div class="col-md-4 mb-3">
                                <label for="streetType"><@spring.message "street.type"/></label>
                                <select class="custom-select d-block w-100" name="streetTypeId" required>
                                    <option value="${currentAddress.streetType?if_exists.id?if_exists}">${currentAddress.streetType?if_exists.name?if_exists}</option>
                                    <#list streetTypes as streetType>
                                        <option value="${streetType.id?if_exists}">${streetType.name?if_exists}</option>
                                    </#list>
                                </select>
                                <div class="invalid-feedback">
                                    Please provide a valid street type.
                                </div>
                            </div>
                            <div class="col-md-4 mb-3">
                                <label for="streetName"><@spring.message "street.name"/></label>
                                <select class="custom-select d-block w-100" name="streetNameId" required>
                                    <option value="${currentAddress.streetName?if_exists.id?if_exists}">${currentAddress.streetName?if_exists.name?if_exists}</option>
                                    <#list streetNames as streetName>
                                        <option value="${streetName.id?if_exists}">${streetName.name?if_exists}</option>
                                    </#list>
                                </select>
                                <div class="invalid-feedback">
                                    Please provide a valid street name.
                                </div>
                            </div>
                            <div class="mb-3">
                                <label for="buildings number"><@spring.message "buildings.number"/></label>
                                <input type="text" class="form-control" name="buildingNumber" placeholder="${currentAddress.buildingNumber?if_exists}" value="${currentAddress.buildingNumber?if_exists}" required>
                                <div class="invalid-feedback">
                                    Please enter a valid buildings number.
                                </div>
                            </div>
                    <#if isUser>
                        <input type="hidden" value="${doctor.id}" name="doctorId">
                    </#if>
                        <input type="hidden" value="${personToEdit.id?if_exists}" name="personId">
                        <input type="hidden" value="${_csrf.token}" name="_csrf">
                        <hr class="mb-5 mt-1">
                        <button type="submit" class="btn btn-success btn-lg btn-block"><@spring.message "save"/></button>
                    </div>
                </div>
            </form>
    <#if requestType="edit">
        <#if personType="doctor">
         <form class="needs-validation" action="/doctor/delete" method="post">
        <#else>
             <form class="needs-validation" action="/patient/delete" method="post">
        </#if>
            <input type="hidden" value="${personToEdit.id?if_exists}" name="personId">
            <input type="hidden" value="${_csrf.token}" name="_csrf">
            <button type="submit" class="btn btn-danger"><@spring.message "delete"/></button>
         </form>
    </#if>

        </div>
</@c.page>