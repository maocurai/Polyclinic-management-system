<#import "parts/common2.ftlh" as c>
<#import "parts/login.ftlh" as l>
<#import "/spring.ftl" as spring/>
<#include "parts/security.ftlh">

<@c.page>
    <div class="py-5 text-center">
        <h2><@spring.message "personal.info"/></h2>
    </div>
    <div class="row mb-2">
        <div class="col-md-12">
            <div class="card flex-md-row mb-4 box-shadow h-md-250">
                <div class="card-body d-flex flex-column align-items-start">
                    <table class="table table-striped mt-3">
                        <tbody>
                        <tr><td><@spring.message "name.person"/></td><td>${patient.fullName}</td></tr>
                        <tr><td><@spring.message "phone.number"/></td><td>${patient.personalInformation.phone}</td></tr>
                        <tr><td>Email</td><td>${patient.personalInformation.email}</td></tr>
                        <tr><td><@spring.message "date.of.birth"/></td><td>${patient.personalInformation.dateOfBirth}</td></tr>
                        <tr><td><@spring.message "city"/></td><td>${patient.personalInformation.address.city.name}</td></tr>
                        <tr><td><@spring.message "region"/></td><td>${patient.personalInformation.address.region.name}</td></tr>
                        <tr><td><@spring.message "street.type"/></td><td>${patient.personalInformation.address.streetType.name}</td></tr>
                        <tr><td><@spring.message "street.name"/></td><td>${patient.personalInformation.address.streetName.name}</td></tr>
                        <tr><td><@spring.message "buildings.number"/></td><td>${patient.personalInformation.address.buildingNumber}</td></tr>
                        <#if !isUser>
                        <td><a href="/patient/${patient.id}" class="btn btn-outline-primary" ><@spring.message "edit"/></a></td>
                        </#if>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <img class="d-block mx-auto mb-4" src="https://freesvg.org/img/abstract-user-flat-1.png" alt="" width="300" height="300">
            </div>
        </div>
    </div>

    <h5 class="mt-5"><@spring.message "doctors"/></h5>
    <div class="row rounded">
    <div class="col-md-12">
    <table class="table table-striped mt-3">
        <thead>
        <tr>
            <th><@spring.message "name.person"/></th>
            <th><@spring.message "specialisation"/></th>
        </tr>
        </thead>
        <tbody>
        <#list patientDoctors as doctor>
            <tr>
                <div class="row mt-3">
                    <td>${doctor.fullName}</td>
                    <td>${doctor.specializationOfDoctor.name}</td>
                </div>
            </tr>
        </#list>
        </tbody>
    </table>
    </div>
    </div>

    <h5 class="mt-5"><@spring.message "certificates.of.illness"/></h5>
    <#list certificatesOfIllness as certificateOfIllness>
    <div class="row rounded">
        <div class="col-md-12">
            <div class="card flex-md-row mb-4 box-shadow h-md-250">
                <div class="card-body d-flex flex-column align-items-start">
                    <table class="table table-striped mt-3">
                        <tbody>
                        <tr><td><@spring.message "date"/></td><td>${certificateOfIllness.dateOfBirth}</td></tr>
                        <tr><td><@spring.message "medical.institution"/></td>
                            <td><p>${certificateOfIllness.medicalInstitution.name} <br>${certificateOfIllness.medicalInstitution.address.region.name} ${certificateOfIllness.medicalInstitution.address.city.name} ${certificateOfIllness.medicalInstitution.address.streetType.name} ${certificateOfIllness.medicalInstitution.address.streetName.name} ${certificateOfIllness.medicalInstitution.address.buildingNumber}</p>
                            </td></tr>
                        <tr><td><@spring.message "doctor"/></td><td>${certificateOfIllness.doctor.specializationOfDoctor.name} ${certificateOfIllness.doctor.fullName}</td></tr>
                        <tr><td><@spring.message "disease"/></td><td>${certificateOfIllness.disease.name}</td></tr>
                        <tr><td><@spring.message "disease.type"/></td><td>${certificateOfIllness.disease.diseaseType.name}</td></tr>
                        <tr><td><a href="/doctor/editCertificateOfIllness/${certificateOfIllness.id}" class="btn btn-outline-primary" ><@spring.message "edit"/></a></td></tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
    </#list>
</@c.page>