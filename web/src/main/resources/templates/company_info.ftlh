<#import "layout/base.ftlh" as layout>

<!-- сделать шаблон для страницы  -->
<@layout.render>
    <div class="container-fluid">
        <h3>${company.name}</h3>
    </div>
    <div class="container-fluid">
        <table class = "datatable">
            <tr>
                <th>Name</th>
                <th>OwnerId</th>
                <th>Description</th>
            </tr>
            <tr>
                <td>${company.name}</td>
                <td>${company.ownerId}</td>
                <td>${company.description}</td>
            </tr>
        </table>
    </div>
</@layout.render>