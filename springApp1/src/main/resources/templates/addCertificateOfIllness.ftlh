<#import "parts/common2.ftlh" as c>
<#import "parts/login.ftlh" as l>
<#import "/spring.ftl" as spring/>
<#include "parts/security.ftlh">

<@c.page>

    <div class="py-5 text-center">
        <img class="d-block mx-auto mb-4" src="https://cdn-icons-png.flaticon.com/512/2522/2522539.png" alt="" width="72" height="72">
        <h2 class="mb-3"><@spring.message "certificate.of.illness"/></h2>
<#--        <#if requestType??>-->
            <h4 class="mb-3"><@spring.message "editing"/></h4>
<#--        </#if>-->
    </div>

    <div class="col-md-8 order-md-1">
        <h4 class="mb-3"><@spring.message "who.issured"/></h4>
        <form class="needs-validation" action="/doctor/certificateOfIllness/update" method="post">
            <div class="col-md-12">
                <div class="card flex-md-row mb-4 box-shadow h-md-250">
                    <div class="card-body d-flex flex-column align-items-start">
                        <table class="table table-striped mt-3">
                            <tbody>
                            <tr><td><@spring.message "medical.institution"/></td>
                                <td><p>${doctor.medicalInstitution.name} <br>${doctor.medicalInstitution.address.region.name} ${doctor.medicalInstitution.address.city.name} ${doctor.medicalInstitution.address.streetType.name} ${doctor.medicalInstitution.address.streetName.name} ${doctor.medicalInstitution.address.buildingNumber}</p>
                                </td></tr>
                            <tr><td><@spring.message "doctor"/></td><td>${doctor.specializationOfDoctor.name} ${doctor.fullName}</td></tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
                <div class="mb-3">
                    <h4 class="mb-3"><@spring.message "personal.info"/></h4>
                    <div class="row">
                        <div class="col-md-6 mb-3">
                            <h4 class="mb-3"><@spring.message "name.person"/></h4>
                            <select class="custom-select d-block w-100" name="patientId" required>
<#--                                <option value="${currentAddress.city?if_exists.id?if_exists}">${currentAddress.city?if_exists.name?if_exists}</option>-->
                                <#list doctor.patientSet as patient>
                                    <option value="${patient.id?if_exists}">${patient.fullName?if_exists}</option>
                                </#list>
                            </select>
                        </div>

                        <div class="col-md-6 mb-3">
                            <h4 class="mb-3"><@spring.message "disease"/></h4>
<#--                            <div class="col-md-5 mb-3">-->
                                <select class="custom-select d-block w-100" name="diseaseId">
                                    <#list diseases as disease>
                                        <option value="${disease.id}">${disease.name}</option>
                                    </#list>
                                </select>
<#--                            </div>-->
                        </div>
                    </div>
                </div>

            <div class="mb-4">
                     <h4 class="mb-3"><@spring.message "date"/></h4>
                     <#assign aDateTime = .now>
                     <#assign aDate = aDateTime?date>
                <input type="date" min="1900-01-01" max="${aDate?iso_utc}" class="form-control" name="date" required>
            </div>
                    <input type="hidden" value="${doctor.id}" name="doctorId">
                    <input type="hidden" value="${_csrf.token}" name="_csrf">
                    <button type="submit" class="btn btn-success btn-lg btn-block w-100"><@spring.message "save"/></button>
        </form>


    </div>
</@c.page>