<#import "layout/base.ftlh" as layout>
<#import "spring.ftl" as spring>

<!-- сделать шаблон для страницы  -->
<@layout.render>
    <div class="container-fluid">
        <#if companyForm?? >
            Your submitted data<br>
            Name: ${companyForm.name}<br>
            Description: ${companyForm.description}<br>
        <#else>
            <form action="/api-web/company" method="post">
                <div>Name:</div>
                <input type="text" name="name"/>
                <div>Description:</div>
                <input type="text" name="description"/>
                <input type="submit" value="Submit"/>
                <input type="reset" value="Reset"/>
            </form>
        </#if>
    </div>
</@layout.render>