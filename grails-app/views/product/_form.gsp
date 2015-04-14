<div class="form-group">
	<label for="brand" class="sr-only"></label>
	<g:textField name="brand" class="form-control" list="brands" placeholder="Marca" autofocus="true"/>
	<datalist id="brands">
		<g:each in="${brands}" var="brand">
			<option value="${brand}">
		</g:each>
	</datalist>
</div>

<div class="form-group">
	<label for="measure" class="sr-only"></label>
	<g:select name="measure" from="${['1L', '12Oz', '700ml']}" noSelection="[null:'Medida']" class="form-control"/>
</div>

<div class="form-group">
	<label for="presentation" class="sr-only"></label>
	<g:select name="presentation" from="${['Botella', 'Lata']}" keys="['bottle', 'can']" noSelection="[null:'Presentacion']" class="form-control"/>
</div>