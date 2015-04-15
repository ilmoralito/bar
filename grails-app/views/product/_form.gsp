<div class="form-group">
	<label for="brand" class="sr-only"></label>
	<g:if test="${productType == 'ron'}">
		<g:textField name="brand" class="form-control" placeholder="Marca" autofocus="true"/>
	</g:if>
	<g:else>
		<g:textField name="brand" class="form-control" list="brands" placeholder="Marca" autofocus="true"/>
		<datalist id="brands">
			<g:each in="${brands}" var="brand">
				<option value="${brand}">
			</g:each>
		</datalist>
	</g:else>
</div>

<g:if test="${productType in ['beer', 'cigar']}">
	<div class="form-group">
		<label for="measure" class="sr-only"></label>
		<g:select name="measure" from="${measures}" noSelection="[null:'Medida']" class="form-control"/>
	</div>
</g:if>

<g:if test="${productType in ['beer', 'juice']}">
	<div class="form-group">
		<label for="presentation" class="sr-only"></label>
		<g:select name="presentation" from="${presentations}" keys="['bottle', 'can', 'box']" noSelection="[null:'Presentacion']" class="form-control"/>
	</div>
</g:if>