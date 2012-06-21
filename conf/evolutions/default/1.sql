# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table questionnaire (
  id                        bigint auto_increment not null,
  titre                     varchar(255),
  createur                  varchar(255),
  debut                     datetime,
  fin                       datetime,
  pers_max                  bigint,
  pers_actuel               bigint,
  constraint pk_questionnaire primary key (id))
;

create table utilisateur (
  id                        bigint auto_increment not null,
  nom                       varchar(255),
  pass                      varchar(255),
  constraint pk_utilisateur primary key (id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table questionnaire;

drop table utilisateur;

SET FOREIGN_KEY_CHECKS=1;

