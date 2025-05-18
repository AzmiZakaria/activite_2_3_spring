# Gestion Pation

## Aperçu
Gestion Pation est un projet conçu pour gérer les informations des patients de manière efficace et sécurisée.

## Fonctionnalités
- Afficher les patients
- Faire la pagination
- Chercher les patients
- Supprimer un patient
- Faire des améliorations supplémentaires

## Activité 2:
## Affichage de BD:
 ![alt text](image/image.png)

## Tester quelques opérations de gestion de patients :
![alt text](image/result_operations.png)

## Mapping des entités
![alt text](image/mapping_entity.png)

## Migration vers MySql DB

### ajout de dependence:
![alt text](image/mysql_dependency.png)

### ajout des propriété:
![alt text](image/properties.png)

### affichage de BD
![alt text](image/patientdb_table_mysql.png)
#### Affichage de table patient
![alt text](image/patient_sql.png)

### Creation de l'interface IhopitalService:
![alt text](image/ihopitalservice.png)
### Operation sur les entites
![alt text](image/operation_all.png)

## Activité 3:
## Partie 1
### Lister les patients
![alt text](image/list_patient.png)

### Patient pagination
![alt text](image/patientPagination.png)

### Recherche patient par Keyword
![alt text](image/patient_keyword.png)

### Supprimer patient
![alt text](image/patient_delete.png)

## Partie 2

### Creation de page template
![alt text](image/template_page.png)

### Ajout patient
![alt text](image/ajout_patient.png)

### Validation d'ajout patient
![alt text](image/validation_pation_ajout.png)

### Modifier un patient 
![alt text](image/edit_patient.png)

## Partie 3 
## 1. InMemomy Authentication
### Redirection en cas de non autorisation
![alt text](image/NOTATHORIZED.png)

### Masquer fonctionalité d'Admin
![alt text](image/user1_patientlist_acces.png)

### Custum login interface
![alt text](image/login.png)

## 2. JDBC Authentication

### Table authorities
![alt text](image/autotities_mysql.png)

### Table users
![alt text](image/users_mysql.png)

## 3. UserDetails Service

### Creation des entités User et Role
![alt text](image/entities_security.png)

### Test UserDetailsService

#### App user table
![alt text](image/app_user.png)

#### App user roles table
![alt text](image/app_user_roles.png)

#### Login avec user 15 stocke dans App_user table
![alt text](image/user15_login.png)

#### user 15 connecté avec succes 
![alt text](image/user15_admin.png)