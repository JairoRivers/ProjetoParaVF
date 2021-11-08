function submeter() {
    let nome = document.getElementById("nome").value;
    let fabricante = document.getElementById("fabricante").value;
    let quantidade = document.getElementById("quantidade").value;
    let preco = document.getElementById("preco").value;

    let controle = {
        'nome': nome,
        'fabricante': fabricante,
        'quantidade': quantidade,
        'preco': preco,
    };

    function reqListener (){
        let controle = JSON.parse(this.responseText);
        adicionarPControle(controle);
    }

    let oReq = new XMLHttpRequest();
    oReq.onload = reqListener;
    oReq.open("POST", "controle", true);
    oReq.setRequestHeader("Content-Type", "application/json");
    oReq.send(JSON.stringify(controle));
}

function adicionarPControle (controle){
    let container = document.createElement("div");
    container.classList.add("container");

    let nome = document.createElement("div");
    nome.classList.add("row");
    nome.innerHTML = "<p>" + controle.nome + "</p>";

    let fabricante = document.createElement("div");
    fabricante.classList.add("row");
    fabricante.innerHTML = "<p>" + fabricante.nome + "</p>";

    let quantidade = document.createElement("div");
    quantidade.classList.add("row");
    quantidade.innerHTML = "<p>" + controle.quantidade + "</p>";

    let preco = document.createElement("div");
    preco.classList.add("row");
    let p = document.createElement("p");
    p.innerHTML = controle.preco;
    preco.appendChild(p);

    container.appendChild(nome);
    container.appendChild(quantidade);
    container.appendChild(fabricante);
    container.appendChild(preco);
    document.getElementById("controles").appendChild(container);
};

function exibirControle() {
    let oReq = new XMLHttpRequest();
    oReq.onload = function(){
        let listaDeControles = JSON.parse(this.responseText);
        for (let i = 0; i < listaDeControles.length; i++){
            adicionarPControle((listaDeControles[i]));
        }
    };
    oReq.open("GET", "controle", true);
    oReq.setRequestHeader("Content-Type", "application/json");
    oReq.send();
};

window.addEventListener("load", function (){
    exibirControle();
});