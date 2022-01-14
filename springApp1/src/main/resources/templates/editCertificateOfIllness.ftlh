<#import "parts/common2.ftlh" as c>
<#import "parts/login.ftlh" as l>
<#import "/spring.ftl" as spring/>
<#include "parts/security.ftlh">

<@c.page>

    <div class="py-5 text-center">
        <img class="d-block mx-auto mb-4" src="https://cdn-icons-png.flaticon.com/512/2522/2522539.png" alt="" width="72" height="72">
        <h2 class="mb-3"><@spring.message "certificate.of.illness"/></h2>
        <h4 class="mb-3"><@spring.message "editing"/></h4>
    </div>

    <div class="col-md-8 order-md-1">
        <h4 class="mb-3"><@spring.message "who.issured"/></h4>
        <form class="needs-validation" action="/doctor/saveCertificateOfIllness" method="post">
            <div class="col-md-12">
                <div class="card flex-md-row mb-4 box-shadow h-md-250">
                    <div class="card-body d-flex flex-column align-items-start">
                        <table class="table table-striped mt-3">
                            <tbody>
                            <tr><td><@spring.message "medical.institution"/></td>
                                <td><p>${currCertificateOfIllness.medicalInstitution.name} <br>${currCertificateOfIllness.medicalInstitution.address.region.name} ${currCertificateOfIllness.medicalInstitution.address.city.name} ${currCertificateOfIllness.medicalInstitution.address.streetType.name} ${currCertificateOfIllness.medicalInstitution.address.streetName.name} ${currCertificateOfIllness.medicalInstitution.address.buildingNumber}</p>
                                </td></tr>
                            <tr><td><@spring.message "doctor"/></td><td>${currCertificateOfIllness.doctor.specializationOfDoctor.name} ${currCertificateOfIllness.doctor.fullName}</td></tr>
                            <tr><td><@spring.message "patient"/></td><td>${currCertificateOfIllness.patient.fullName}</td></tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="mb-3">
                <h4 class="mb-3"><@spring.message "personal.info"/></h4>
                <div class="row">
                        <h4 class="mb-3"><@spring.message "disease"/></h4>
                    <div class="col-md-5 mb-3">
                        <select class="custom-select d-block w-100" name="diseaseId">
                            <#list diseases as disease>
                                <option value="${disease.id}">${disease.name}</option>
                            </#list>
                        </select>
                    </div>
                </div>
            </div>

            <div class="mb-4">
                <h4 class="mb-3"><@spring.message "date"/></h4>
                <#assign aDateTime = .now>
                <#assign aDate = aDateTime?date>
                <input type="date" min="1900-01-01" max="${aDate?iso_utc}" value="${currCertificateOfIllness.dateOfBirth}" class="form-control" name="date" required>
            </div>
            <input type="hidden" value="${currCertificateOfIllness.id}" name="certificateId">
            <input type="hidden" value="${_csrf.token}" name="_csrf">
            <button type="submit" class="btn btn-success btn-lg btn-block w-100"><@spring.message "save"/></button>
        </form>
    </div>
</@c.page>