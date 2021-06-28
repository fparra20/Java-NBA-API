# Java-NBA-API

This is a simple documentation on how to get data.

Note: all dates must be formatted as <b>formatted as 'YYYYMMDD'</b>.

Note: only shows information from 2016 to this day.

<h3> Scoreboard </h3>

Get list of games on a given date.

```
Scoreboard sb = new Scoreboard();

// Get all games played on given date
ArrayList<Scoreboard> sbList = sb.getScoreboardListByDate("20210623");

// Show Id and Arena City of the first game on that date.
System.out.println(sbList.get(0).getGameId() + " -- " + sbList.get(0).getArenaCity());

////////// Output //////////

0042000301 -- Milwaukee       
```

For each game you can get gameId, seasonStageId, seasonYear, arenaName, arenaCity, statusNum, startTime (EST), clock, gameDuration, currentPeriod, visitorTeam, localTeam, summaryText.

<h3> Bosxcore </h3>

Get boxscore on a given date and gameId.

```
Boxscore bs = new Boxscore();

// Get boxscore from a game on a given date
ArrayList<Boxscore> bsList = bs.getBoxscoreByDateAndGame("20210622", "0042000312");

// Show player name and points for every Player
for (Boxscore b : bsList) {
    System.out.println(b.getFullName() + " - Points: " + b.getPoints());
}

////////// Output //////////

Paul George - Points: 26
Marcus Morris Sr. - Points: 7
Ivica Zubac - Points: 14
Patrick Beverley - Points: 6
Reggie Jackson - Points: 19
Terance Mann - Points: 8
Rajon Rondo - Points: 8
Nicolas Batum - Points: 3
Luke Kennard - Points: 10
DeMarcus Cousins - Points: 2
Amir Coffey - Points: 0
Yogi Ferrell - Points: 0
Daniel Oturu - Points: 0
Patrick Patterson - Points: 0
Jay Scrubb - Points: 0
Mikal Bridges - Points: 5
Jae Crowder - Points: 2
Deandre Ayton - Points: 24
Devin Booker - Points: 20
Cameron Payne - Points: 29
E'Twaun Moore - Points: 2
Cameron Johnson - Points: 11
Torrey Craig - Points: 0
Dario Saric - Points: 11
Ty-Shon Alexander - Points: 0
Jevon Carter - Points: 0
Langston Galloway - Points: 0
Frank Kaminsky - Points: 0
Jalen Smith - Points: 0       
```

For each player you can get points, pos, min, fgm, fga, fgp, ftm, fta, ftp, tpm, tpa, tpp, offReb, defReb, totReb, assists, pFouls, steals, turnovers, blocks, plusMinus, dnp;

<h3> Player </h3>

Get players info.

```
// Get all players on the league at the moment
ArrayList<Player> pList = new Player().getAllPlayers();

// Show full name for every Player
for (Player p : pList) {
    System.out.println(p.getFullName());
}

////////// Output //////////
Precious Achiuwa
Steven Adams
Bam Adebayo
Ty-Shon Alexander
Nickeil Alexander-Walker
Grayson Allen
...
```

```
// Get all players on a team
ArrayList<Player> pList = new Player().getPlayersByTeamUrl("raptors");

// Show full name and age for every Player on the Raptors
for (Player p : pList) {
    System.out.println(p.getFullName() + " " + p.getAge());
}

////////// Output //////////
Kyle Lowry 35y, 2d
Aron Baynes 34y, 18d
Rodney Hood 28y, 7d
Khem Birch 28y, 30d
Stanley Johnson 25y, 29d
...
```

```
// Get a specific player given its Id and Team
Player p = new Player().getPlayerProfileFromId("203078", "wizards");

// Get player's full name, college and teamId
System.out.println(p.getFullName() + " " + p.getCollegeName() + " " + p.getTeamId());

////////// Output //////////
Bradley Beal Florida/USA 1610612764
```

For each player you can get firstName, lastName, personId, teamId, jersey, pos, height(cm), weight(kg), dateOfBirthUTC, yearsPro, collegeName, country.

<h3> Team </h3>

Get teams info.

```
// Get a specific team given its Id
Team tm = new Team().getTeamById("1610612764");

// Get team's full name and conference
System.out.println(tm.getFullName() + " " + tm.getConfName());

////////// Output //////////

Washington Wizards East
```

```
// Get a list with all teams
ArrayList<Team> tmList = new Team().getAllTeams();

// Get all teams full name and tricode
for (Team t : tmList) {
    System.out.println(t.getFullName() + " " + t.getTricode());
}

////////// Output //////////

Atlanta Hawks ATL
Boston Celtics BOS
Brooklyn Nets BKN
Charlotte Hornets CHA
Chicago Bulls CHI
Cleveland Cavaliers CLE
...
```

For each team you can get teamId, city, nickname, fullName, tricode, confName, divName, urlName.

<h3> Standings </h3>

Get league standings.

```
// Get all east conference standings at the moment
ArrayList<Standings> east = new Standings().getStandingsEast();

// Get all west conference standings at the moment
ArrayList<Standings> west = new Standings().getStandingsWest();

// Get east's teams tricode and Win - Loss
for (Standings s : east) {

     // Get team tricode given the Id
     String tm = new Team().getTeamById(s.getTeamId()).getTricode();

     System.out.println(tm + " " + s.getWin() + "-" + s.getLoss());
}
        
////////// Output //////////
PHI 49-23
BKN 48-24
MIL 46-26
NYK 41-31
ATL 41-31
...
```

For each team you can get teamId, win, loss, winPct, tricode, gamesBehind, lastTenWin, lastTenLoss, streak, confRank.

<h3> PlayOffs </h3>

Get league Playoffs series.

```
// Get matches on a given year, conference and round
ArrayList<PlayoffsBracket> round_one = new PlayoffsBracket().getPlayOffsBracketByYearConfRound(2020, "East", "1");

// Get teams tricode and Wins
for (PlayoffsBracket pb : round_one) {

    // Store top Team's (team with better seed) Tricode
    String topTeamTricode = new Team().getTeamById(pb.getTopRow().getTeamId()).getTricode();
            
    // Store bottom Team's Tricode
    String bottomTeamTricode = new Team().getTeamById(pb.getBottomRow().getTeamId()).getTricode();

    System.out.println(topTeamTricode + ": " + pb.getTopRow().getWins());
    System.out.println(bottomTeamTricode + ": " + pb.getBottomRow().getWins());
    System.out.println("__");
}
        
////////// Output //////////
PHI: 4
WAS: 1
__
NYK: 1
ATL: 4
__
MIL: 4
MIA: 0
__
BKN: 4
BOS: 1
__
```

For each series you can get roundNum, confName, seriesId, isSeriesCompleted, summaryStatusText, gameNumber, topRow (team with better seed on RS), bottomRow, streak, confRank.

