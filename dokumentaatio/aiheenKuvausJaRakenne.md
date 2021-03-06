#Oskillaattori

##Kuvaus
Pyrkimyksenä on luoda yksinkertainen oskillaattori javalla. Oskillaattori on eräänlainen nykymusiikissa käytetty soitin. 
Muokkaamalla äänikortille lähetettävää signaalia ja liittämällä useampia elementtejä yhteen voidaan soittaa monimutkaisia ääniä.

#####Käyttäjä:
Musiikinharrastaja tai siitä kiinnostunut

#####Käyttäjän toiminnot:
- Käyttäjä voi luoda ja muokata ääntä käyttöliittymän kautta
- Käyttäjä voi soittaa luomaansa ääntä koskettimilla
- Käyttäjä voi kirjoittaa syötekenttään nuotteja ja ohjelma soittaa ne käyttäjälle takaisin

##Rakennekuvaus
#####Luokkakaavio
![Alt text](Luokkakaavio.png "Luokkakaavio")

Ohjelma sisältää Syntetisaattorin joka alustaa muut käytettävät käytännön luokat, ja hoitaa 
soittamisen. Mikseri pitää sisällään linjoja, joita pitkin äänidata kulkee halutusta lähteestä
haluttuun päämäärään eli loppujen lopuksi äänikortin outputtiin. Oskilaattorit itsessään luovat
erilaisia aaltomuotoja olevaa ääntä eri taajuuksilta luoden sävelkorkeuseroja, joita voidaan käyttää nuotteina ja soittaa GUIn kautta käyttäjälle. 
Lukija-luokka lukee käyttäjän tekstisyötettä ja kääntää sen nuoteiksi, jotka syntetisaattori soittaa käyttäjälle. Tempo-luokka laskee nuottien pituuksia halutulla temmolla.

#####Sekvenssikaavio
![Alt text](Sekvenssikaavio.png "Sekvenssikaavio")

##Käyttöohje
Aluksi käyttäjä valitsee kolmelle oskillaattorille aaltomuodot kolmesta vaihtoehdosta.
Tämän jälkeen käyttäjä voi halutessaan muokata oskillaattoreiden taajuuksia ja äänenvoimakkuutta. Sen jälkeen käyttäjä pääsee soittamaan koskettimistolta luomaansa ääntä.
