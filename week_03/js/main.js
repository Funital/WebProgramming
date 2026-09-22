function toggleSystem(){
    const status=document.getElementById("status");
    const button=document.getElementById("systemButton");
    const message=document.getElementById("message");
    const isOnline=status.classList.toggle("on");

    if(isOnline){
        status.textContent="ONLINE";
        button.textContent="SYSTEM STOP";
        message.textContent="시스템이 활성화되었습니다.";
    }else{
        status.textContent="OFFLINE";
        button.textContent="SYSTEM START";
        message.textContent="미래의 IT 기기를 탐색하는 웹서비스";
    }
}

const products = [
    {name: "AAA", type: "aaa"},
    {name: "BBB", type: "bbb"},
    {name: "CCC", type: "ccc"}
];

function loadCatalog(){
    const catalog=document.getElementById("catalog");
    catalog.replaceChildren();
    for(const product of products){
        const card=document.createElement("article");
        card.className="product-card";
        const type=document.createElement("span");
        type.className="product-type";
        type.textContent=product.type;

        const title=document.createElement("h3");
        title.textContent=product.name;

        card.appendChild(type);
        card.appendChild(title);
        catalog.append(card);
    }
}






document.getElementById("systemButton").addEventListener("click", toggleSystem);
document.getElementById("loadButton").addEventListener("click", loadCatalog);