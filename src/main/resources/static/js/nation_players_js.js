$.when(
    $.getScript( "/node_modules/chart.js/dist/Chart.js" ),
    $.getScript( "https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js" ),
    $.getScript( "js/MyRequestsCompleted.js"),
    $.Deferred(function( deferred ){
        $( deferred.resolve );
    })
).done(function() {
    var dataStored = [];
    var nations = [];
    var nationsList = ["Argentina",
        "Australia",
        "Austria",
        "Belgium",
        "Bolivia",
        "Brazil",
        "Bulgaria",
        "Cameroon",
        "Canada",
        "Chile",
        "China PR",
        "Colombia",
        "Côte d'Ivoire",
        "Czech Republic",
        "Denmark",
        "Ecuador",
        "Egypt",
        "England",
        "Finland",
        "France",
        "Germany",
        "Greece",
        "Hungary",
        "Iceland",
        "India",
        "Ireland",
        "Italy",
        "Mexico",
        "Netherlands",
        "New Zealand",
        "Northern Ireland",
        "Norway",
        "Paraguay",
        "Peru",
        "Poland",
        "Portugal",
        "Romania",
        "Russia",
        "Saudi Arabia",
        "Scotland",
        "Slovenia",
        "South Africa",
        "Spain",
        "Sweden",
        "Switzerland",
        "Turkey",
        "United States",
        "Uruguay",
        "Venezuela",
        "Wales"];
    $(document).ready(function () {
        var requestCallback = new MyRequestsCompleted({
            numRequest: nationsList.length,
            singleCallback: function () {
                draw();
            }
        });
        nationsList.forEach(searchPlayers);

        function searchPlayers(nation, index) {
            $.ajax({
                url: "/players/nationality/" + nation,
                dataType: 'json'
            })
                .done(function (data) {
                    dataStored.push(data.length);
                    nations.push(nation);
                    requestCallback.requestComplete(true);
                });
        }

        function draw() {
            console.log("Fatto");
            var ctx = document.getElementById("myChart").getContext('2d');
            var stringColors = [];
            for (var i = 0; i < nationsList.length; i++) {
                stringColors[i] = 'rgba(' + Math.floor(Math.random() * 256) + ', ' + Math.floor(Math.random() * 256) + ', ' + Math.floor(Math.random() * 256) + ', ' + 0.2 + ')';
            }
            var myChart = new Chart(ctx, {
                type: 'bar',
                data: {
                    labels: nations,
                    datasets: [{
                        label: '# di giocatori',
                        data: dataStored,
                        backgroundColor: stringColors,
                        borderColor: stringColors,
                        borderWidth: 1
                    }]
                },
                options: {
                    scales: {
                        yAxes: [{
                            ticks: {
                                beginAtZero: true
                            }
                        }]
                    }
                }
            });
        };
    });
});