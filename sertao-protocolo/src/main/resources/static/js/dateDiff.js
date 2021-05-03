
function botaoFunfa() {
    document.querySelector("input[name=\"dateFim\"]").disabled = false;
    var dataIniciio = document.querySelector("input[name=\"dateInicio\"]").value;
    var dataFim = document.querySelector("input[name=\"dateFim\"]").value;

    var periodo = document.querySelector("p[id=\"periodo\"]");
    periodo.innerHTML=calcDate(dataFim, dataIniciio);
}

function botaoBotapegado() {
    var dataIniciio = document.querySelector("input[name=\"dateInicio\"]").value;
    var dataFim = document.querySelector("input[name=\"dateFim\"]").value;

    var periodo = document.querySelector("p[id=\"periodo\"]");
    periodo.innerHTML=calcDate(dataFim, dataIniciio);

}

function calcDate(date1,date2) {

    date1 = new Date(date1)
    date2 = new Date(date2)

    var diff = Math.floor(date1.getTime() - date2.getTime());
    var day = 1000 * 60 * 60 * 24;

    var days = Math.floor(diff/day);

    return days + " Dias "
}


a = calcDate(today,past)
console.log(a)