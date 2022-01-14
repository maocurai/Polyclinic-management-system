<#import "parts/common2.ftlh" as c>
<#import "parts/login.ftlh" as l>
<#import "/spring.ftl" as spring/>
<#include "parts/security.ftlh">

<@c.page>

    <div class="py-5 text-center">
        <img class="d-block mx-auto mb-4" src="https://icons.veryicon.com/png/o/commerce-shopping/b2b-shopping-mall/region.png" alt="" width="72" height="72">
        <h2><@spring.message "statistics"/></h2>
        <p class="lead"><@spring.message "statistics.regions.text"/></p>
    </div>

        <form class="needs-validation" action="/statistics/diseaseInRegions" method="get">
            <div class="mb-3">
                <div class="row">
                    <div class="col-md-2">
                        <h4><@spring.message "disease"/></h4>
                    </div>
                    <div class="col-md-8">
                        <select class="custom-select d-block w-100 h-100" name="diseaseId">
                            <option value="${currDisease?if_exists.id?if_exists}">${currDisease?if_exists.name?if_exists}</option>
                            <#list diseases as disease>
                                <option value="${disease.id}">${disease.name}</option>
                            </#list>
                        </select>
                        <div class="invalid-feedback">
                            Please provide a valid role.
                        </div>
                    </div>
                    <div class="col-md-2">
                        <button type="submit" class="btn btn-primary w-100"><@spring.message "show"/></button>
                    </div>
                </div>
            </div>
        </form>


    <#if currDisease??>
        <h5>${currDisease?if_exists.name?if_exists}</h5>
    </#if>
    <h5 class="mt-5"><@spring.message "by.medical.institution.address"/></h5>
    <div class="row rounded">
        <div class="col-md-12">
            <table class="table table-striped mt-3">
                <thead>
                <tr>
                    <th><@spring.message "amount"/></th>
                    <th><@spring.message "region"/></th>
                </tr>
                </thead>
                <tbody>
                <#list patientsWithDisease as patientWithDisease>
                    <tr>
                        <div class="row mt-3">
                            <td>${patientWithDisease.patientsCount}</td>
                            <td>${patientWithDisease.regionName}</td>
                        </div>
                    </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </div>

    <h5 class="mt-5"><@spring.message "by.patient.address"/></h5>
    <div class="row rounded">
        <div class="col-md-12">
            <table class="table table-striped mt-3">
                <thead>
                <tr>
                    <th><@spring.message "amount"/></th>
                    <th><@spring.message "region"/></th>
                </tr>
                </thead>
                <tbody>
                <#list patientsWithDiseaseByPatientAddress as patientWithDiseaseByPatientAddress>
                    <tr>
                        <div class="row mt-3">
                            <td>${patientWithDiseaseByPatientAddress.patientsCount}</td>
                            <td>${patientWithDiseaseByPatientAddress.regionName}</td>
                        </div>
                    </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </div>
</@c.page>