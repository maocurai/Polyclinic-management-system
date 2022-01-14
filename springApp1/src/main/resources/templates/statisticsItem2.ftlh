<#import "parts/common2.ftlh" as c>
<#import "parts/login.ftlh" as l>
<#import "/spring.ftl" as spring/>
<#include "parts/security.ftlh">

<@c.page>

    <div class="py-5 text-center">
        <img class="d-block mx-auto mb-4" src="https://icons.veryicon.com/png/o/commerce-shopping/b2b-shopping-mall/region.png" alt="" width="72" height="72">
        <h2><@spring.message "statistics"/></h2>
        <p class="lead"><@spring.message "statistics.patients.in.medical.institutions.in.city.text"/></p>
    </div>

        <form class="needs-validation" action="/statistics/patientsInMedicalInstitutions" method="get">
            <div class="mb-3">
                <div class="row">
                    <div class="col-md-2">
                        <h4><@spring.message "city"/></h4>
                    </div>
                    <div class="col-md-8">
                        <select class="custom-select d-block w-100 h-100" name="cityId">
                            <option value="${currCity?if_exists.name?if_exists}">${currCity?if_exists.name?if_exists}</option>
                            <#list cities as city>
                                <option value="${city.id}">${city.name}</option>
                            </#list>
                        </select>
                        <div class="invalid-feedback">
                            Please provide a valid city.
                        </div>
                    </div>
                    <div class="col-md-2">
                        <button type="submit" class="btn btn-primary w-100"><@spring.message "show"/></button>
                    </div>
                </div>
            </div>
        </form>

    <#if currCity??>
        <h5>${currCity?if_exists.name?if_exists}</h5>
    </#if>
        <h5 class="mt-5"></h5>
        <div class="row rounded">
            <div class="col-md-12">
                <table class="table table-striped mt-3">
                    <thead>
                    <tr>
                        <th><@spring.message "amount"/></th>
                        <th><@spring.message "medical.institution"/></th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list patientsInMedicalInstitutions as patientInMedicalInstitutions>
                        <tr>
                            <div class="row mt-3">
                                <td>${patientInMedicalInstitutions.patientsCount}</td>
                                <td>${patientInMedicalInstitutions.name}</td>
                            </div>
                        </tr>
                    </#list>
                    </tbody>
                </table>
            </div>
        </div>
</@c.page>