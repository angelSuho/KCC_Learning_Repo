let replyService = (function(){
  function create() {
    console.log('replyService create');
  }

  function update() {
    console.log('replyService update');
  }

  function read() {
    console.log('replyService read');
  }

  function remove() {
    console.log('replyService remove');
  }

  function getList(param, callback) {
    let data = '결과값: ' + param;
    callback(data);
  }

  return {
    create: create,
    update: update,
    read: read,
    remove: remove,
    getList: getList
  }
})();


function show() {
  replyService.create();
  replyService.update();
  replyService.read();
  replyService.remove();
  replyService.getList('kosa', function(result) {
    console.log(`내가 원하는 형태의 출력: ${result}`);
  });
}

show();

console.log('=====================================');
function orderService(item, price, quantity, callback) {
  console.log('커피 주문');
  // 주문 로직 처리
  function order() {
    let totalPrice = price * quantity;
    print(totalPrice);
  }

  function cancel() {
    console.log('주문 취소');
  }

  function print(totalPrice) {
    console.log('주문 내역 출력');
    console.log(`주문 상품: ${item}`);
    console.log(`가격: ${price}원`);
    console.log(`수량: ${quantity}개`);
    callback(totalPrice);
  }

  return {
    order: order,
    cancel: cancel
  }
}

function order() {
  let order = orderService('아메리카노', 2000, 2, function(totalPrice) {
    console.log(`총 주문 금액: ${totalPrice}원`);
  });

  order.order();
  console.log("---");
  order.cancel();
  console.log("---");
}

order();