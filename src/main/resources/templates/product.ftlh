<#import "/spring.ftl" as spring>
<#import "partials/main.ftlh" as main />

<@main.renderWith scripts=["js/product.js"]>

    <h2 id="product-type">${product}</h2>
    <div id="products" class="row">
        <#list items as item>
            <div class="card d-inline-block" style="width: 18rem;" id="${item.id}">
            </div>
        </#list>
    </div>

</@main.renderWith>