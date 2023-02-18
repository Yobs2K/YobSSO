<#import "layout/base.ftlh" as layout>

<!-- сделать шаблон для страницы  -->
<@layout.render>
    <div class="container-fluid">
        <h3>Список компаний</h3>
    </div><table>
        <tr>
            <th>Name</th>
            <th>OwnerId</th>
            <th>Description</th>
        </tr>
        <#list companies.content as company>
            <tr>
                <td>${company.name}</td>
                <td>${company.ownerId}</td>
                <td>${company.description}</td>
            </tr>
        </#list>
    </table>
</@layout.render>