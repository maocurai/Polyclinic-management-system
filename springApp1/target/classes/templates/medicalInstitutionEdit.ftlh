<#import "parts/common2.ftlh" as c>
<#import "parts/login.ftlh" as l>
<#import "/spring.ftl" as spring/>
<#include "parts/security.ftlh">

<@c.page>

    <div class="py-5 text-center">
        <img class="d-block mx-auto mb-4" src="https://cdn-icons-png.flaticon.com/512/88/88977.png" alt="" width="72" height="72">
        <#if requestType="edit">
            <h2><@spring.message "edit"/> <@spring.message "profile"/></h2>
        <#else>
            <h2><@spring.message "add"/> <@spring.message "profile"/></h2>
        </#if>
    </div>

    <div class="col-md-8 order-md-1">
            <form class="needs-validation" action="/medicalInstitution/update" method="post">
                <div class="mb-3">
                    <label for="username"><@spring.message "name"/></label>
                    <div class="input-group">
                        <input type="text" class="form-control" name="Name" placeholder="${medicalInstitutionToEdit.name?if_exists}" value="${medicalInstitutionToEdit.name?if_exists}" required>
                        <div class="invalid-feedback" style="width: 100%;">
                            Your username is required.
                        </div>
                    </div>
                </div>
                <hr class="mb-4 mt-4">
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
                        <input type="hidden" value="${medicalInstitutionToEdit.id?if_exists}" name="medicalInstitutionId">
                        <input type="hidden" value="${_csrf.token}" name="_csrf">
                        <hr class="mb-5 mt-1">
                        <button type="submit" class="btn btn-success btn-lg btn-block"><@spring.message "save"/></button>
                    </div>
                </div>
            </form>
            <#if requestType="edit">
                <form class="needs-validation" action="/medicalInstitution/delete" method="post">
                    <input type="hidden" value="${medicalInstitutionToEdit.id?if_exists}" name="medicalInstitutionId">
                    <input type="hidden" value="${_csrf.token}" name="_csrf">
                    <button type="submit" class="btn btn-danger btn-lg btn-block"><@spring.message "delete"/></button>
                </form>
            </#if>
    </div>
</@c.page>