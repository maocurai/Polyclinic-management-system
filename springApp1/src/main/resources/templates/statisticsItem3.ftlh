<#import "parts/common2.ftlh" as c>
<#import "parts/login.ftlh" as l>
<#import "/spring.ftl" as spring/>
<#include "parts/security.ftlh">

<@c.page>

    <div class="py-5 text-center">
        <img class="d-block mx-auto mb-4" src="https://icons.veryicon.com/png/o/commerce-shopping/b2b-shopping-mall/region.png" alt="" width="72" height="72">
        <h2><@spring.message "statistics"/></h2>
        <p class="lead"><@spring.message "statistics.by.month"/></p>
    </div>

    <form class="needs-validation" action="/statistics/certificatesOfIllnessByMonth" method="get">
        <div class="mb-3">
            <div class="row">
                <div class="col-md-2">
                    <h4><@spring.message "month"/></h4>
                </div>
                <div class="col-md-3">
                    <select class="custom-select d-block w-100 h-100" name="monthId">
                        <option value="${selectedMonth?if_exists}">${selectedMonth?if_exists}</option>
                        <#list monthNumbers as monthNumbers>
                            <option value="${monthNumbers}">${monthNumbers}</option>
                        </#list>
                    </select>
                    <div class="invalid-feedback">
                        Please provide a valid city.
                    </div>
                </div>
                <div class="col-md-2">
                    <h4><@spring.message "year"/></h4>
                </div>
                <div class="col-md-3">
                    <select class="custom-select d-block w-100 h-100" name="yearId">
                        <option value="${selectedYear?if_exists}">${selectedYear?if_exists}</option>
                        <#list years as year>
                            <option value="${year.years?c}">${year.years?c}</option>
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

    <h5 class="mt-5"></h5>
    <div class="row rounded">
        <div class="col-md-12">
            <table class="table table-striped mt-3">
                <thead>
                <tr>
                    <th><@spring.message "amount"/></th>
                    <th><@spring.message "disease"/></th>
                </tr>
                </thead>
                <tbody>
                <#list certificatesOfIllnessByMonth as certificateOfIllnessByMonth>
                    <tr>
                        <div class="row mt-3">
                            <td>${certificateOfIllnessByMonth.patientsCount}</td>
                            <td>${certificateOfIllnessByMonth.diseaseName}</td>
                        </div>
                    </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </div>
</@c.page>