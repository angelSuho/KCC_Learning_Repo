function showPic(obj) {
    let source = obj.getAttribute("href");
    let placeholder = document.getElementById("placeholder");
    placeholder.setAttribute("src", source); 

    let text = obj.getAttribute("title");
    let description = document.getElementById("description");
    // description.innerHTML = text;

    // nodeType 3번은 텍스트 노드
    if (description.firstChild.nodeType == 3) {
        description.firstChild.nodeValue = text;
    }

    // 뒤에 덧붙이기
    // description.insertAdjacentHTML("beforeend", text);
}

// e.preventDefault()를 사용하여 기본 이벤트를 막을 수 있다.
function prepareGallery() {
    const imageGallery = document.getElementById("imagegallery");
    const aTags = imageGallery.getElementsByTagName("a");
    for (let i = 0; i < aTags.length; i++) {
        // aTags[i].onclick = function(e) {
        //     showPic(this);
        //     e.preventDefault();
        // }
        aTags[i].addEventListener("click", function(e) {
            e.preventDefault();
            showPic(this);
        }, false);
    }
}

window.onload = prepareGallery;
