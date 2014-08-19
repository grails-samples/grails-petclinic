${label}: <span class="errors">
	<g:fieldError bean="${bean}" field="${field}" />
</span>
<br/>
<g:textField name="${name + '_' + field}"
             value="${fieldValue(bean:bean, field:field)}" />
