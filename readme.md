## Projet particules   

Hugo Stawiarski - ESGI4 AL

Limite pour l'utilsiation sur mon pc : 350 particules
Lancer le projet : sbt run 

Ajouter une video de démo + repo propre



#### Simulateur de particules

Cette application simule des particules qui se déplacent indéfiniment dans l'environnement.  
  
Chaque particule est un cercle défini par:  
  
son rayon: fixe (le même pour toutes les autres particules)  
sa couleur: aléatoire  
sa position: aléatoire   
sa direction: aléatoire selon le voisinage de Moore    
  

À chaque cycle:  
   
une particule se déplace dans la prochaine case suivant sa direction  
si elle arrive aux bords de l'environnement, elle réapparaît de l'autre côté  
si elle cogne une autre particule, elle change de direction et prend une autre direction aléatoire  



https://github.com/user-attachments/assets/320b219a-cddf-4a10-bac7-f8aab829ffee
