function adicionarProduto(produto) {
    let tr = document.createElement("tr");
    tr.id = "produto-" + produto.id;

    let id = document.createElement("th");
    id.innerHTML = produto.id;
    tr.appendChild(id);

    let nome = document.createElement("td");
    nome.innerHTML = produto.nome;
    tr.appendChild(nome);

    let fabricante = document.createElement("td");
    fabricante.innerHTML = produto.data;
    tr.appendChild(fabricante);

    let quantidade = document.createElement("td");
    quantidade.innerHTML = produto.quantidade;
    tr.appendChild(quantidade);

    let preco = document.createElement("td");
    preco.innerHTML = produto.preco;
    tr.appendChild(preco);

    let categoria = document.createElement("td");
    categoria.innerHTML = produto.categoria;
    tr.appendChild(categoria);

    let codigoDeBarras = document.createElement("td");
    preco.innerHTML = produto.codigoDeBarras;
    tr.appendChild(codigoDeBarras);

    let opcoes = document.createElement("td");
    let btnRemover = document.createElement("button");
    btnRemover.innerHTML = "Remover";
    btnRemover.type = "button";
    btnRemover.onclick = function () {
        removerProduto(produto.id);
    };
    opcoes.appendChild(btnRemover);

    let btnAtualizar = document.createElement("button");
    btnAtualizar.innerHTML = "Atualizar";
    btnAtualizar.type = "button";
    btnAtualizar.onclick = function () {
        incluirProdutoNoFormulario(produto);
    };
    opcoes.appendChild(btnAtualizar);

    tr.appendChild(opcoes);

    document.getElementById("corpoTabela").appendChild(tr);
}

function exibirProdutos() {
    let oReq = new XMLHttpRequest();
    oReq.onload = function () {
        let listDeProdutos = JSON.parse(this.responseText);
        for (let i = 0; i < listDeProdutos.length; i++) {
            adicionarProduto(listDeProdutos[i]);
        }
    };
    oReq.open("GET", "peca", true);
    oReq.setRequestHeader("Content-Type", "application/json");
    oReq.send();
}

window.addEventListener("load", function () {
    exibirProdutos();
});

function cadastrarProduto() {
    let produto = {
        'id': document.getElementById("id-entidade").value,
        'nome': document.getElementById("nome").value,
        'data': document.getElementById("data").value,
        'quantidade': document.getElementById("quantidade").value,
        'preco': document.getElementById("preco").value,
        'categoria': document.getElementById("categoria").value,
        'codigoDeBarras': document.getElementById("codigoDeBarras").value,
    }

    if (produto.id == "") {
        let oReq = new XMLHttpRequest();
        oReq.onload = function () {
            let produto = JSON.parse(this.responseText);
            adicionarProduto(produto);
        };
        oReq.open("POST", "produto", true);
        oReq.setRequestHeader("Content-Type", "application/json");
        oReq.send(JSON.stringify(produto));
    } else {
        let oReq = new XMLHttpRequest();
        oReq.onload = function () {
            apagarLinhaDaTabela(produto.id);
            adicionarProduto(produto);
        };
        oReq.open("PUT", "produto/" + produto.id, true);
        oReq.setRequestHeader("Content-Type", "application/json");
        oReq.send(JSON.stringify(produto));
    }

    limparFormulario();
}

function limparFormulario() {
    document.getElementById("id-entidade").value = "";
    document.getElementById("nome").value = "";
    document.getElementById("data").value = "";
    document.getElementById("quantidade").value = "";
    document.getElementById("preco").value = "";
    document.getElementById("categoria").value = "";
    document.getElementById("codigoDeBarras").value = "";
}

function removerProduto(id) {
    let oReq = new XMLHttpRequest();
    oReq.onload = function () {
        apagarLinhaDaTabela(id);
    };
    oReq.open("DELETE", "produto/" + id, true);
    oReq.setRequestHeader("Content-Type", "application/json");
    oReq.send();
}

function apagarLinhaDaTabela(produtoId) {
    let produtoNaTabela = document.getElementById("peca-" + produtoId);
    document.getElementById("corpoTabela").removeChild(produtoNaTabela);
}

function incluirProdutoNoFormulario(produto) {
    document.getElementById("id-entidade").value = produto.id;
    document.getElementById("nome").value = produto.nome;
    document.getElementById("fabricante").value = produto.fabricante;
    document.getElementById("quantidade").value = produto.quantidade;
    document.getElementById("preco").value = produto.preco;
    document.getElementById("categoria").value = produto.categoria;
    document.getElementById("codigoDeBarras").value = produto.codigoDeBarras;
}