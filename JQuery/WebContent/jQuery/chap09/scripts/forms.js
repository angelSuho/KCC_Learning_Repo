$(function() {
	$('.quantity input').change(function() {
		let totalCost = 0;
		let totalQuantity = 0;
		
		$('table tbody tr').each(function(index) {
			let price = parseFloat($(this).find('.price').text()
			.replace(/^[^\d.]/,''));
			price = isNaN(price) ? 0 : price;
			console.log(price);
			
			let quantity = parseInt($(this).find('.quantity input').val());
			quantity = isNaN(quantity) ? 0 : quantity;
			
			const cost = price * quantity;
			$(this).find('.cost').text('$' + cost.toFixed(2));
			totalCost += cost;
			totalQuantity += quantity;
		});
		
		const subTotalCost = $('.subtotal .cost');
		const shipping = $('.shipping .quantity');
		const taxCost = $('.tax .cost');
		const shippingCost = $('.shipping .cost');
		
		subTotalCost.text('$' + totalCost.toFixed(2));
		shipping.text(totalQuantity);
		
		// 주말 과제
		// 1. 변경된 subTotal 값에 비례하여 6%에 해당하는 결과 세금을 계산해보자.
		// 2. 변경된 Shipping 값에 비례하여 $2에 해당하는 결과 배송비를 계산해보자.
		taxCost.text('$' + (totalCost * 0.06).toFixed(2));
		shippingCost.text('$' + (totalQuantity * 2));
		$('.total .cost').text('$' + 
				(parseInt(subTotalCost.text().slice(1)) + 
				parseInt(taxCost.text().slice(1)) +
				parseInt(shippingCost.text().slice(1))).toFixed(2));
		
	});
});