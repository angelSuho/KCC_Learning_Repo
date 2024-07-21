// $(document).ready(function() { 축약
$(function() {
    // 상품 추가
    $('#addCart').click(function(e) {
        e.preventDefault();
        const name = $('#insert-pname').val();
        const quantity = parseInt($('#insert-pquantity').val());
        const price = parseInt($('#insert-pprice').val().replace(/[^0-9]/g, ""));
    
        if (isNaN(price) || isNaN(quantity)) {
            alert('가격과 수량은 숫자로 입력해주세요.');
            console.error('유효하지 않은 가격 값입니다.');
            return;
        }
        const lineCost = price * quantity;

        const row = '<tr><td class="product-name">' + name + '</td>' + 
        '<td class="product-price">₩' + price + '원' + '</td>' + 
        '<td><button class="quantity-decrease">-</button>' + 
        '<input type="text" class="quantity-input" value="' + quantity + '">' + 
        '<button class="quantity-increase">+</button></td>' + 
        '<td class="product-subtotal">₩' + lineCost + '원' + '</td>' + 
        '<td><button class="delete-btn">X</button></td></tr>';
        
        $('table tbody').append(row);
        updateTotalCost();
    });

    // 수량 증가
    $('#productTable').on('click', '.quantity-increase', function() {
        var input = $(this).siblings('.quantity-input');
        var currentValue = parseInt(input.val());
        if (!isNaN(currentValue)) {
            // , 단위로 표시된 숫자를 숫자로 변환
            input.val(currentValue + 1);
            updateLineCost($(this).closest('tr')); // 상위 tr 태그 찾기
        }
    });

    // 수량 감소
    $('#productTable').on('click', '.quantity-decrease', function() {
        var input = $(this).siblings('.quantity-input');
        var currentValue = parseInt(input.val());
        if (!isNaN(currentValue) && currentValue > 1) {
            input.val(currentValue - 1);
            updateLineCost($(this).closest('tr')); // 상위 tr 태그 찾기
        } else {
            alert('최소 수량은 1개입니다.');
        }
    });

    // 상품 삭제
    $('#productTable').on('click', '.delete-btn', function() {
        $(this).closest('tr').remove();
        updateTotalCost();
    });

    // 주문 시작
    $('#charge-btn').click(function() {
        alert('주문 화면으로 이동합니다.');
    });

    // 상품 소계와 전체 합계 업데이트
    function updateLineCost(row) {
        var price = parseFloat(row.find('.product-price').text().replace(/[^0-9.-]+/g, ""));
        var quantity = parseInt(row.find('.quantity-input').val());
        var lineCost = price * quantity;
        row.find('.product-subtotal').text('₩' + lineCost + '원');
        updateTotalCost();
    }

    // 전체 합계 업데이트
    function updateTotalCost() {
        var totalCost = 0;
        $('table tbody tr').each(function() {
            var lineCost = parseFloat($(this).find('.product-subtotal').text().replace(/[^0-9.-]+/g, ""));
            totalCost += lineCost;
        });
        $('.total-cost').text('₩' + totalCost + '원');
    }
});
