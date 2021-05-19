PGDMP     ,                    y            sertao_protocolo #   12.6 (Ubuntu 12.6-0ubuntu0.20.04.1) #   12.6 (Ubuntu 12.6-0ubuntu0.20.04.1) ^    +           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            ,           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            -           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            .           1262    24589    sertao_protocolo    DATABASE     �   CREATE DATABASE sertao_protocolo WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'pt_BR.UTF-8' LC_CTYPE = 'pt_BR.UTF-8';
     DROP DATABASE sertao_protocolo;
                postgres    false            �            1259    27572    aviso    TABLE     m   CREATE TABLE public.aviso (
    id bigint NOT NULL,
    descricao text,
    titulo character varying(255)
);
    DROP TABLE public.aviso;
       public         heap    postgres    false            �            1259    24590    cargos    TABLE     a   CREATE TABLE public.cargos (
    id bigint NOT NULL,
    nome character varying(255) NOT NULL
);
    DROP TABLE public.cargos;
       public         heap    postgres    false            �            1259    24792    categoria_protocolo    TABLE     �   CREATE TABLE public.categoria_protocolo (
    id bigint NOT NULL,
    abreviacao character varying(255),
    descricao character varying(255),
    nome character varying(255)
);
 '   DROP TABLE public.categoria_protocolo;
       public         heap    postgres    false            �            1259    25637    cidades    TABLE     b   CREATE TABLE public.cidades (
    id bigint NOT NULL,
    nome character varying(255) NOT NULL
);
    DROP TABLE public.cidades;
       public         heap    postgres    false            �            1259    24600 	   enderecos    TABLE     A  CREATE TABLE public.enderecos (
    id bigint NOT NULL,
    bairro character varying(255) NOT NULL,
    cep character varying(9) NOT NULL,
    complemento character varying(255),
    logradouro character varying(255) NOT NULL,
    numero integer NOT NULL,
    id_cidade_fk bigint,
    uf character varying(2) NOT NULL
);
    DROP TABLE public.enderecos;
       public         heap    postgres    false            �            1259    26961 
   func_aviso    TABLE     e   CREATE TABLE public.func_aviso (
    aviso_id bigint NOT NULL,
    funcionario_id bigint NOT NULL
);
    DROP TABLE public.func_aviso;
       public         heap    postgres    false            �            1259    27524    funcionarios    TABLE     �   CREATE TABLE public.funcionarios (
    id bigint NOT NULL,
    matricula character varying(255),
    nome character varying(255),
    telefone character varying(255),
    id_cargo_fk bigint,
    endereco_id_fk bigint,
    id_subsetor_fk bigint
);
     DROP TABLE public.funcionarios;
       public         heap    postgres    false            �            1259    24610    hibernate_sequence    SEQUENCE     {   CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.hibernate_sequence;
       public          postgres    false            �            1259    24649    instituicaos    TABLE     �   CREATE TABLE public.instituicaos (
    id bigint NOT NULL,
    ativo boolean,
    bloqueado boolean,
    cnpj character varying(14) NOT NULL,
    nome character varying(255) NOT NULL,
    endereco_id_fk bigint
);
     DROP TABLE public.instituicaos;
       public         heap    postgres    false            �            1259    27580 	   protocolo    TABLE       CREATE TABLE public.protocolo (
    id bigint NOT NULL,
    assunto character varying(120),
    fim date,
    inicio date,
    descricao text,
    n_protolo character varying(255),
    status character varying(2) NOT NULL,
    id_categoria_fk bigint,
    id_funcionario_fk bigint
);
    DROP TABLE public.protocolo;
       public         heap    postgres    false            �            1259    27433    resposta_protocolo    TABLE     �   CREATE TABLE public.resposta_protocolo (
    id bigint NOT NULL,
    data_resposta date,
    resposta text,
    funcionario_id_fk bigint,
    id_protocolo_fk bigint
);
 &   DROP TABLE public.resposta_protocolo;
       public         heap    postgres    false            �            1259    24746    roles    TABLE     W   CREATE TABLE public.roles (
    id bigint NOT NULL,
    role character varying(255)
);
    DROP TABLE public.roles;
       public         heap    postgres    false            �            1259    24627    setores    TABLE     �   CREATE TABLE public.setores (
    id bigint NOT NULL,
    ativo boolean,
    nome character varying(255),
    id_instituicao_fk bigint
);
    DROP TABLE public.setores;
       public         heap    postgres    false            �            1259    24617    sub_setores    TABLE     �   CREATE TABLE public.sub_setores (
    id bigint NOT NULL,
    ativo boolean,
    nome character varying(255),
    id_setor_fk bigint
);
    DROP TABLE public.sub_setores;
       public         heap    postgres    false            �            1259    27762 	   user_role    TABLE     \   CREATE TABLE public.user_role (
    user_id bigint NOT NULL,
    role_id bigint NOT NULL
);
    DROP TABLE public.user_role;
       public         heap    postgres    false            �            1259    27767    users    TABLE     �   CREATE TABLE public.users (
    id bigint NOT NULL,
    active boolean,
    email character varying(255),
    password character varying(255),
    user_name character varying(255),
    funcionario_id bigint
);
    DROP TABLE public.users;
       public         heap    postgres    false                       2613    26146    26146    BLOB     &   SELECT pg_catalog.lo_create('26146');
 &   SELECT pg_catalog.lo_unlink('26146');
                postgres    false                       2613    26212    26212    BLOB     &   SELECT pg_catalog.lo_create('26212');
 &   SELECT pg_catalog.lo_unlink('26212');
                postgres    false                       2613    26753    26753    BLOB     &   SELECT pg_catalog.lo_create('26753');
 &   SELECT pg_catalog.lo_unlink('26753');
                postgres    false                       2613    26799    26799    BLOB     &   SELECT pg_catalog.lo_create('26799');
 &   SELECT pg_catalog.lo_unlink('26799');
                postgres    false                       2613    26805    26805    BLOB     &   SELECT pg_catalog.lo_create('26805');
 &   SELECT pg_catalog.lo_unlink('26805');
                postgres    false                       2613    26821    26821    BLOB     &   SELECT pg_catalog.lo_create('26821');
 &   SELECT pg_catalog.lo_unlink('26821');
                postgres    false                       2613    26902    26902    BLOB     &   SELECT pg_catalog.lo_create('26902');
 &   SELECT pg_catalog.lo_unlink('26902');
                postgres    false                       2613    26933    26933    BLOB     &   SELECT pg_catalog.lo_create('26933');
 &   SELECT pg_catalog.lo_unlink('26933');
                postgres    false                       2613    26944    26944    BLOB     &   SELECT pg_catalog.lo_create('26944');
 &   SELECT pg_catalog.lo_unlink('26944');
                postgres    false                       2613    26950    26950    BLOB     &   SELECT pg_catalog.lo_create('26950');
 &   SELECT pg_catalog.lo_unlink('26950');
                postgres    false                       2613    26979    26979    BLOB     &   SELECT pg_catalog.lo_create('26979');
 &   SELECT pg_catalog.lo_unlink('26979');
                postgres    false                       2613    26985    26985    BLOB     &   SELECT pg_catalog.lo_create('26985');
 &   SELECT pg_catalog.lo_unlink('26985');
                postgres    false                       2613    27001    27001    BLOB     &   SELECT pg_catalog.lo_create('27001');
 &   SELECT pg_catalog.lo_unlink('27001');
                postgres    false                       2613    27012    27012    BLOB     &   SELECT pg_catalog.lo_create('27012');
 &   SELECT pg_catalog.lo_unlink('27012');
                postgres    false                       2613    27023    27023    BLOB     &   SELECT pg_catalog.lo_create('27023');
 &   SELECT pg_catalog.lo_unlink('27023');
                postgres    false                       2613    27044    27044    BLOB     &   SELECT pg_catalog.lo_create('27044');
 &   SELECT pg_catalog.lo_unlink('27044');
                postgres    false                       2613    27050    27050    BLOB     &   SELECT pg_catalog.lo_create('27050');
 &   SELECT pg_catalog.lo_unlink('27050');
                postgres    false                       2613    27056    27056    BLOB     &   SELECT pg_catalog.lo_create('27056');
 &   SELECT pg_catalog.lo_unlink('27056');
                postgres    false                       2613    27303    27303    BLOB     &   SELECT pg_catalog.lo_create('27303');
 &   SELECT pg_catalog.lo_unlink('27303');
                postgres    false                       2613    27414    27414    BLOB     &   SELECT pg_catalog.lo_create('27414');
 &   SELECT pg_catalog.lo_unlink('27414');
                postgres    false                       2613    27425    27425    BLOB     &   SELECT pg_catalog.lo_create('27425');
 &   SELECT pg_catalog.lo_unlink('27425');
                postgres    false                        2613    27426    27426    BLOB     &   SELECT pg_catalog.lo_create('27426');
 &   SELECT pg_catalog.lo_unlink('27426');
                postgres    false            !           2613    27432    27432    BLOB     &   SELECT pg_catalog.lo_create('27432');
 &   SELECT pg_catalog.lo_unlink('27432');
                postgres    false            "           2613    27456    27456    BLOB     &   SELECT pg_catalog.lo_create('27456');
 &   SELECT pg_catalog.lo_unlink('27456');
                postgres    false            #           2613    27457    27457    BLOB     &   SELECT pg_catalog.lo_create('27457');
 &   SELECT pg_catalog.lo_unlink('27457');
                postgres    false            $           2613    27508    27508    BLOB     &   SELECT pg_catalog.lo_create('27508');
 &   SELECT pg_catalog.lo_unlink('27508');
                postgres    false            %           2613    27850    27850    BLOB     &   SELECT pg_catalog.lo_create('27850');
 &   SELECT pg_catalog.lo_unlink('27850');
                postgres    false            &           2613    27851    27851    BLOB     &   SELECT pg_catalog.lo_create('27851');
 &   SELECT pg_catalog.lo_unlink('27851');
                postgres    false            '           2613    27852    27852    BLOB     &   SELECT pg_catalog.lo_create('27852');
 &   SELECT pg_catalog.lo_unlink('27852');
                postgres    false                      0    27572    aviso 
   TABLE DATA           6   COPY public.aviso (id, descricao, titulo) FROM stdin;
    public          postgres    false    214   �c       �          0    24590    cargos 
   TABLE DATA           *   COPY public.cargos (id, nome) FROM stdin;
    public          postgres    false    202   d                 0    24792    categoria_protocolo 
   TABLE DATA           N   COPY public.categoria_protocolo (id, abreviacao, descricao, nome) FROM stdin;
    public          postgres    false    209   od                 0    25637    cidades 
   TABLE DATA           +   COPY public.cidades (id, nome) FROM stdin;
    public          postgres    false    210   �d       �          0    24600 	   enderecos 
   TABLE DATA           g   COPY public.enderecos (id, bairro, cep, complemento, logradouro, numero, id_cidade_fk, uf) FROM stdin;
    public          postgres    false    203   ��                 0    26961 
   func_aviso 
   TABLE DATA           >   COPY public.func_aviso (aviso_id, funcionario_id) FROM stdin;
    public          postgres    false    211   ��                 0    27524    funcionarios 
   TABLE DATA           r   COPY public.funcionarios (id, matricula, nome, telefone, id_cargo_fk, endereco_id_fk, id_subsetor_fk) FROM stdin;
    public          postgres    false    213   %�                  0    24649    instituicaos 
   TABLE DATA           X   COPY public.instituicaos (id, ativo, bloqueado, cnpj, nome, endereco_id_fk) FROM stdin;
    public          postgres    false    207   ��                 0    27580 	   protocolo 
   TABLE DATA              COPY public.protocolo (id, assunto, fim, inicio, descricao, n_protolo, status, id_categoria_fk, id_funcionario_fk) FROM stdin;
    public          postgres    false    215   ;�                 0    27433    resposta_protocolo 
   TABLE DATA           m   COPY public.resposta_protocolo (id, data_resposta, resposta, funcionario_id_fk, id_protocolo_fk) FROM stdin;
    public          postgres    false    212   ��                 0    24746    roles 
   TABLE DATA           )   COPY public.roles (id, role) FROM stdin;
    public          postgres    false    208   ��       �          0    24627    setores 
   TABLE DATA           E   COPY public.setores (id, ativo, nome, id_instituicao_fk) FROM stdin;
    public          postgres    false    206   (�       �          0    24617    sub_setores 
   TABLE DATA           C   COPY public.sub_setores (id, ativo, nome, id_setor_fk) FROM stdin;
    public          postgres    false    205   ��       	          0    27762 	   user_role 
   TABLE DATA           5   COPY public.user_role (user_id, role_id) FROM stdin;
    public          postgres    false    216   
�       
          0    27767    users 
   TABLE DATA           W   COPY public.users (id, active, email, password, user_name, funcionario_id) FROM stdin;
    public          postgres    false    217   :�       /           0    0    hibernate_sequence    SEQUENCE SET     A   SELECT pg_catalog.setval('public.hibernate_sequence', 93, true);
          public          postgres    false    204            (          0    0    BLOBS    BLOBS                             false   |       j           2606    27579    aviso aviso_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.aviso
    ADD CONSTRAINT aviso_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.aviso DROP CONSTRAINT aviso_pkey;
       public            postgres    false    214            R           2606    24594    cargos cargos_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.cargos
    ADD CONSTRAINT cargos_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.cargos DROP CONSTRAINT cargos_pkey;
       public            postgres    false    202            b           2606    24799 ,   categoria_protocolo categoria_protocolo_pkey 
   CONSTRAINT     j   ALTER TABLE ONLY public.categoria_protocolo
    ADD CONSTRAINT categoria_protocolo_pkey PRIMARY KEY (id);
 V   ALTER TABLE ONLY public.categoria_protocolo DROP CONSTRAINT categoria_protocolo_pkey;
       public            postgres    false    209            d           2606    25641    cidades cidades_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.cidades
    ADD CONSTRAINT cidades_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.cidades DROP CONSTRAINT cidades_pkey;
       public            postgres    false    210            V           2606    24607    enderecos enderecos_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.enderecos
    ADD CONSTRAINT enderecos_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.enderecos DROP CONSTRAINT enderecos_pkey;
       public            postgres    false    203            h           2606    27531    funcionarios funcionarios_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.funcionarios
    ADD CONSTRAINT funcionarios_pkey PRIMARY KEY (id);
 H   ALTER TABLE ONLY public.funcionarios DROP CONSTRAINT funcionarios_pkey;
       public            postgres    false    213            \           2606    24653    instituicaos instituicaos_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.instituicaos
    ADD CONSTRAINT instituicaos_pkey PRIMARY KEY (id);
 H   ALTER TABLE ONLY public.instituicaos DROP CONSTRAINT instituicaos_pkey;
       public            postgres    false    207            l           2606    27587    protocolo protocolo_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.protocolo
    ADD CONSTRAINT protocolo_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.protocolo DROP CONSTRAINT protocolo_pkey;
       public            postgres    false    215            f           2606    27440 *   resposta_protocolo resposta_protocolo_pkey 
   CONSTRAINT     h   ALTER TABLE ONLY public.resposta_protocolo
    ADD CONSTRAINT resposta_protocolo_pkey PRIMARY KEY (id);
 T   ALTER TABLE ONLY public.resposta_protocolo DROP CONSTRAINT resposta_protocolo_pkey;
       public            postgres    false    212            `           2606    24750    roles roles_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.roles DROP CONSTRAINT roles_pkey;
       public            postgres    false    208            Z           2606    24631    setores setores_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.setores
    ADD CONSTRAINT setores_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.setores DROP CONSTRAINT setores_pkey;
       public            postgres    false    206            X           2606    24621    sub_setores sub_setores_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.sub_setores
    ADD CONSTRAINT sub_setores_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.sub_setores DROP CONSTRAINT sub_setores_pkey;
       public            postgres    false    205            ^           2606    24655 )   instituicaos uk_dsf61vjun90hm2njbub7xcw44 
   CONSTRAINT     d   ALTER TABLE ONLY public.instituicaos
    ADD CONSTRAINT uk_dsf61vjun90hm2njbub7xcw44 UNIQUE (cnpj);
 S   ALTER TABLE ONLY public.instituicaos DROP CONSTRAINT uk_dsf61vjun90hm2njbub7xcw44;
       public            postgres    false    207            T           2606    24609 #   cargos uk_gseglqgqp16hn9j3pqn06m8oy 
   CONSTRAINT     ^   ALTER TABLE ONLY public.cargos
    ADD CONSTRAINT uk_gseglqgqp16hn9j3pqn06m8oy UNIQUE (nome);
 M   ALTER TABLE ONLY public.cargos DROP CONSTRAINT uk_gseglqgqp16hn9j3pqn06m8oy;
       public            postgres    false    202            n           2606    27766    user_role user_role_pkey 
   CONSTRAINT     d   ALTER TABLE ONLY public.user_role
    ADD CONSTRAINT user_role_pkey PRIMARY KEY (user_id, role_id);
 B   ALTER TABLE ONLY public.user_role DROP CONSTRAINT user_role_pkey;
       public            postgres    false    216    216            p           2606    27774    users users_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
       public            postgres    false    217            v           2606    27542 (   funcionarios fk3qpeu6e4lxnghbisl8hwqm0oe    FK CONSTRAINT     �   ALTER TABLE ONLY public.funcionarios
    ADD CONSTRAINT fk3qpeu6e4lxnghbisl8hwqm0oe FOREIGN KEY (endereco_id_fk) REFERENCES public.enderecos(id);
 R   ALTER TABLE ONLY public.funcionarios DROP CONSTRAINT fk3qpeu6e4lxnghbisl8hwqm0oe;
       public          postgres    false    213    2902    203            r           2606    24644 '   sub_setores fk4wcldjy527fbcknvopt41uiic    FK CONSTRAINT     �   ALTER TABLE ONLY public.sub_setores
    ADD CONSTRAINT fk4wcldjy527fbcknvopt41uiic FOREIGN KEY (id_setor_fk) REFERENCES public.setores(id);
 Q   ALTER TABLE ONLY public.sub_setores DROP CONSTRAINT fk4wcldjy527fbcknvopt41uiic;
       public          postgres    false    206    205    2906            y           2606    27603 %   protocolo fk79tpapdwd8g2f0l3h3n3hhj6b    FK CONSTRAINT     �   ALTER TABLE ONLY public.protocolo
    ADD CONSTRAINT fk79tpapdwd8g2f0l3h3n3hhj6b FOREIGN KEY (id_funcionario_fk) REFERENCES public.funcionarios(id);
 O   ALTER TABLE ONLY public.protocolo DROP CONSTRAINT fk79tpapdwd8g2f0l3h3n3hhj6b;
       public          postgres    false    213    215    2920            x           2606    27598 %   protocolo fkc2rhdykjk486vvhf22vh54v2c    FK CONSTRAINT     �   ALTER TABLE ONLY public.protocolo
    ADD CONSTRAINT fkc2rhdykjk486vvhf22vh54v2c FOREIGN KEY (id_categoria_fk) REFERENCES public.categoria_protocolo(id);
 O   ALTER TABLE ONLY public.protocolo DROP CONSTRAINT fkc2rhdykjk486vvhf22vh54v2c;
       public          postgres    false    215    2914    209            |           2606    27805 !   users fkd2wy4njxh1hb2ap8xxtgt3ryl    FK CONSTRAINT     �   ALTER TABLE ONLY public.users
    ADD CONSTRAINT fkd2wy4njxh1hb2ap8xxtgt3ryl FOREIGN KEY (funcionario_id) REFERENCES public.funcionarios(id);
 K   ALTER TABLE ONLY public.users DROP CONSTRAINT fkd2wy4njxh1hb2ap8xxtgt3ryl;
       public          postgres    false    213    2920    217            q           2606    25642 %   enderecos fkd7i8gdrus2p80pakwpxbaqxos    FK CONSTRAINT     �   ALTER TABLE ONLY public.enderecos
    ADD CONSTRAINT fkd7i8gdrus2p80pakwpxbaqxos FOREIGN KEY (id_cidade_fk) REFERENCES public.cidades(id);
 O   ALTER TABLE ONLY public.enderecos DROP CONSTRAINT fkd7i8gdrus2p80pakwpxbaqxos;
       public          postgres    false    203    210    2916            {           2606    27800 %   user_role fkj345gk1bovqvfame88rcx7yyx    FK CONSTRAINT     �   ALTER TABLE ONLY public.user_role
    ADD CONSTRAINT fkj345gk1bovqvfame88rcx7yyx FOREIGN KEY (user_id) REFERENCES public.users(id);
 O   ALTER TABLE ONLY public.user_role DROP CONSTRAINT fkj345gk1bovqvfame88rcx7yyx;
       public          postgres    false    2928    216    217            w           2606    27547 (   funcionarios fklrkw1prulg7nhp0pkkq7lwj6q    FK CONSTRAINT     �   ALTER TABLE ONLY public.funcionarios
    ADD CONSTRAINT fklrkw1prulg7nhp0pkkq7lwj6q FOREIGN KEY (id_subsetor_fk) REFERENCES public.sub_setores(id);
 R   ALTER TABLE ONLY public.funcionarios DROP CONSTRAINT fklrkw1prulg7nhp0pkkq7lwj6q;
       public          postgres    false    213    205    2904            s           2606    24661 #   setores fkqcktjyvkm32tddkxlsu5jsgbi    FK CONSTRAINT     �   ALTER TABLE ONLY public.setores
    ADD CONSTRAINT fkqcktjyvkm32tddkxlsu5jsgbi FOREIGN KEY (id_instituicao_fk) REFERENCES public.instituicaos(id);
 M   ALTER TABLE ONLY public.setores DROP CONSTRAINT fkqcktjyvkm32tddkxlsu5jsgbi;
       public          postgres    false    2908    206    207            t           2606    24656 (   instituicaos fkrdwpo99ao4c2f6q6ke3qdx6if    FK CONSTRAINT     �   ALTER TABLE ONLY public.instituicaos
    ADD CONSTRAINT fkrdwpo99ao4c2f6q6ke3qdx6if FOREIGN KEY (endereco_id_fk) REFERENCES public.enderecos(id);
 R   ALTER TABLE ONLY public.instituicaos DROP CONSTRAINT fkrdwpo99ao4c2f6q6ke3qdx6if;
       public          postgres    false    207    2902    203            z           2606    27795 %   user_role fkt7e7djp752sqn6w22i6ocqy6q    FK CONSTRAINT     �   ALTER TABLE ONLY public.user_role
    ADD CONSTRAINT fkt7e7djp752sqn6w22i6ocqy6q FOREIGN KEY (role_id) REFERENCES public.roles(id);
 O   ALTER TABLE ONLY public.user_role DROP CONSTRAINT fkt7e7djp752sqn6w22i6ocqy6q;
       public          postgres    false    2912    208    216            u           2606    27537 (   funcionarios fktkkwtttadypkvw6dpjo4rjoya    FK CONSTRAINT     �   ALTER TABLE ONLY public.funcionarios
    ADD CONSTRAINT fktkkwtttadypkvw6dpjo4rjoya FOREIGN KEY (id_cargo_fk) REFERENCES public.cargos(id);
 R   ALTER TABLE ONLY public.funcionarios DROP CONSTRAINT fktkkwtttadypkvw6dpjo4rjoya;
       public          postgres    false    213    202    2898                  x��4�42�05�ts�tt������ 2�3      �   [   x�31�ttw�qUpt����	r��W�Up�1�21�#m�eb�Gژ����	�!>�f\�@��F(��yn�Vpwr������ �-�         `   x�36��uq�J-,�,�<����|�����T��ĒԢ���b�� OG.sN 3��5��(5=Q!%U���$1%_!75%39_� ��ş+F��� 9z�            x�t�=w�F��k�~��1޵߀���D^���T�LB,�d&��L�K�f�k�5�@�F/�Ze��#��g� Ii,�>�N ���uv$������ۋ�����?�z|�N��x�j�%^dn}�?��}����o/
Ou��}Q��о�H=}�TM�`�lH��/��%��������E����\���Ǯ?twË$��=���㋄�����vo���x�]\�[�@�xc��/�dm��-i�<�[�OY5Y_�So'�`>�+��}�"M<��ǋ4U��f$Ƨ}�ڭ������]��^N��p��͋�n�>t�i-�����ތ/����;�ev��v��N=�ny7�of��6?/2��ݡowO��Mo/��~7����?�������rw�>ڃ�����q���{�X�hy�y�u�����dw���s?x�Ëܜ������������_��<�0�Bp�����A^~��?������ƪ�Ż�p�^�U0?�o�%h"8�;�@�z��g8�冗Qd����3K,��u��(n�v���uxQ�ϲ��"���^���^�ŗSD��R��s�^�E�?:��et�G{�y��}2/�\�]�yQ?���6��EYF|�eZ���L�q|���~��EY/������ws�lV�����_��`W�<{����J���p�G�J'��p1w�+�R�1�f8���T���ö�|�VR`���f�C�7��yQ��������O�E����e�VU��`�������)bm�[����a�����huY�����X�!u��nx׽��h��lV{>�&Y�t����v�ۋ&���M��Ҷ4���;��j̝��>�.7���Ԛ�b���u?:Y��z�f�߬a[��]g����SK>~u�C��4�t�9[2������dU���s�KO�m/>�D~�]�V�����W�՞�~N[o�i#�����QZ���4��ۇS6��\�ܱ����h�u�������;nN���V��g���f^p���'@�?z�;������{I`�q|k�+Ob0��m%p�f��oO�R�bUȞ�'�;�a_�EF��	�"gA!�}wX��'������l��z ���x�h���P��r����_�9SNo�~�$.(&p�<&0�"�J���!��:��=uk/�=�����ӓ�����c�>��3�/�3���y�>>�|�w��n-'��wh�m��[hw/~�NJ��0����^�{�����c��8�'`�AJ����֗)B�ޚk�F�*B�~�1�x5E(�U�����
�e�v���o�����-Oߨ�E��R��-��:)�9O�L'�.|�e�������!x���_���-�\r��:��ji����5��l�T�:n���I*�{����<�*u�Yo�,$x��P�޴��-]K�F�e{xh7TN�h��瑩"��a�����a�1���G̟W��F��M���NV���z���k���x�#��V50ض��G�m���=oS��G�����_����/���i��S��U��dS��TA�� �ݡ�s�{}���;�t��l���5�˯Z3+��nv��6Cn�۲^��H0���_���vG���v1�.lh�m;�:�La��}t�6���0���ޜ��R�/&된�Ko���O��L�vu�S�p�7�`�׻VcXp��[��~���/��I}�`��t�V
���id���-�8m�7��4J[�׍�+x�2ByR�|?Z*��aĬ�OO���SKS�`���^P�n����B_3��;�&��ט
����4�_��T�u$P�R��G�X��l�0
��O���_d��=Uk�<�:���֍���~c�.�����BHX��EJ���������2�?����<�O�W�����s���Q$���<ҍH��]����zCߎ�����fē�*�фV7wv��l�˄IvT(����@=�>v��RH��ܝ�c0�0)��S�?Z�FWhf�K���)ܱ0�K�?�����AB
kD�ہ�ֆ>_Z��j��H�b6Y���XZ����?�f�Z,3��LsÛB+{q>�Z(���]h�S(f�:M�'��,rܗ��)��9�9#���O�� �a���[; ���v��x���pPK���U���4���4�ާ���@m�Oh��B�I�>ܱ7�����;�Lw�_��>�cϨ�AT
g�ߵ�45��Ш�7�	����{����e {���t!��a�C�4��ː��K�bw���K4!���*�F�AXVo��S�V����;�눊E&-�7��J�㣥�/ܲI�����}��e�����#K�[U�,�WV�5O=K� u�$�.�<5T��o�e̥͒*��=�,��P���E����!K� �5e���c�7��>i�ʡ������^�ʙmg)���)+y�����r!Lee�`��29��y��t�����e��eY>s-+�YɲҁՅ,�����uH�j���6�j�<�>f��
����i/�3�>O��C���[g�N���T婵̵��=��	i=�B�?�Zg��~TF�H��'=�B���dV��^����O߸I����B����Y��?���Rw���h�������!�����L$�4���\���pg��>t4P��%7��<���#7�/M+�8=�Ѻ��`�f�{ͮ�à��lW�I%�5Wr����ԇɪ��SO�N
��mXr�xE��n�]M�PP�K{Iỡ�<�h���9�j���n@�}����&����W�#����^.������ n1$�s�E=��n�c��� t���ҪZk�'�VUi~��X�lY�q�<���7��t���Ck�(��ۏ�p��|����z�YW�e���1L��j�e�d��Ĭ1[G�z��Ǆ���s5�����ۈ���\�0���g�����hC�#sʴ��#�?��$MRN�{<Z-�isI��AN�+�����k�[���̞awz�\�sZ�����W�	�h��r�'mΝ��9��nbz1�Mc�QO��؀}9M1���=ԟ��vm��̻�^����4ʲYmV��]9��²HN#l��a��:�~��K.��FG���g����}�/rZpKm�Ӻ���i�mX��6-�_r���0�h�c��0eD�1�l�[N�n�7�INî.�Y�#�q��+��?��ߘ%S����
��L����kO��Ӹ+��k�o�G���LL���^i�����g�"��ޓj�sk�o�~������d����Ȅg����[�>��Z�ﭸ�|�o;�Ϣ�0o�Y��>��k�N�y�:3x��֟X�(���2U�		Qy^���Vf^�A����M�Ⱥ�mv����Ը��C^V�lk�Ө;/�e���[�<�a�2�m�?|3�ji���a��̫�<�*�]�J�֏�n��S�L�0���|����-y��qMʵ�U#PQ���i�]U�t���ގ�5�V���	LE����J^gK�������x�۵�ϖ����ӿ[*o݄�ƕq�7����]�:�$g�SwO�&o҅٪�F�&[Xo��=�h3�K33�,?�QLb�q�3VJ�}����VH�q���Z����C(VIL��գ���N?�����%f0���`�pUy��������&^��b��HV�l��kk��%���U��k�Ŝ�f_����$�3;.'��q���[�+y�sPER>˻a�mc��-#������^�5���ŧ��E�ZVQ�4Y�4Q��l�3�E�-�t�y�i>�ڵ��"-f�M���"-g�{c�T��C�)�"]俌m0.J��"[-��֧ͺ(�OF٢,�F뮘i.�u0���Ze�0o��!��� ��bn�o=�%��S�΂�j���Y�<�k���I�6E�N��lF��L��Ѯ�V�K�?��@Arw�;	�W��)s�p��ʋ"9�i�����,@V���5?v����;c�oZ�;<l#Tk���%�Ǝ�Y�w����^��L��Eo1�+}�,�o��u��N�������Ư���w�֛U1a*C    �d�֐^2�P�J�RM���e{h!�EƼ� �:���Z��v4@`gy�RP��g����e|6�Y/�n���=P*#��N�d6'󐔧�o�(&S��1�?��\�EW�ja|���*����ؗ���Zf�����VՊ&Y9=�=EE�9��&w�U{��S4�㛐]:|�;7Tn��݀��I�J������U	�9�g����Y4iլ��������pY��¤�58;��'����.G	�u��bZ���d2�ܵ;�rl����c�qK-*�=��KBu�ou*�8�c�g7L�J(n6�0%�a�ڲ�^�r��c�����+b�炥�5ߘ_+a1ñ\B^݁nx	gu'��+� �����w���5
�`������*!��橄��0aWBC��][��轅�G�D�4�y�0a#���h�@	������4T�/��}vy�e����I��T���?��g&�'D�!�?媖@9����Ɖ�\J��n�#��Ό�.�G��rS�����ʛg��k�e���bF�|�T|��gYGk�ǧ����W�,�)>W��y���NWeޜg�����S��헻5�+�s�G�}��ܬ�Vd��Ova+5�f�F�n�Cf��hqmüf��͋�զt�s�^Bl�n�az��W�E4����	�w�v�As��w����g���p�`�Q�ã����e��3ë��F��(���&�0]�y�������J��,#<�{wA���P}��%�W3떍zurn����(���\��3���6����2c.R],�V|���g�������ڡP�����U���@����<�x*�չ�W��&97��4�qk�M��:+5�j�Ý���z�o����ƿ�mS6�3Ӳ�n�909�s/��n?����*���j�,�up��q\�"�*{��g�Xb��%C<%ժ<ϋ�P1n�*�s��l���5C�TrQ�
��8��T0��2ܩ���d@��bN�s���uH.��,l>}CSy9yO��J� �	R�����3{,J���Z'�4~2XA���B+t�q����RV0����nnb+��2o{K�
3Sĝ��h-Y�q��X�O�Vd]�O�*������+>�;+9��5���������`C�[�CuI+���X��
#����CVР��/*�.��*��<92���f�|�s��o�`7�0����̰�E�,'T�"��}��"��zoE���U!׏O�6ʬf��q-�ΟY�h�*W1��`y��ކ9�������l�z�Yڣ*ΐvVP��	��;��>o��!��Oō�,�*�[;�D�
��,�dk=�����6U�͖�uT�d;��W+�1��VUyf8#���B�o��*/��ߪ
���A�B��(g���9��
�c��ns�����p���r����Af���%��������neǩQ;gyڰ� i\�z:�G���d]��vwz�0��-~��O�������[�f��k��u͝Q{�*(��}�p	�axςF� ��!�@s��<�ﬆ:�0�}���h?��昍Wb��u=�G�M���$8��v�Lp����l���2v����f�j�cT�Nm���j=c�����6�0ph�֥��/h��6�x�2e�i���b�q�!Fjc��9m�7���\�X��wS}�qgCm�z��7������*����N�{s�~G������:��֢�DMMp����<���a����Z��.�:+�[���QlN�/����Tg��f|mi����uG��s\�~���:Of���fJ�)�γ�y��y~n��΋s�������Ү���$���F<�(y}nWa���x�x�_Vhk��bQ�i�g]$i]�3V�bY��M�BN����Y1S�Y�sC��0)�����
�B%뷷�����ji|ecc��2�V+w��]ĺT1�r`��X�J�`�,���^��$���
���q�)��ġ�4/��*Xx�U"��TiHbΔ�=�;�����.Xq�;�T��S���g�~�}	z�����9\���=�%�����qŚݾ����8��=~S,A9���U�ՙ�������_�[ϰ���ShTyeP7r�]4u�C_��d�L�}Ͽ6� _@S(	34�����.۩��2�{op��`�mV8�E��	�O�'�HnAR�*��hI|ڨ�1P8�]g�6l�mVUH�lڬ�hcv�5nxaL+�Ѝ�\�$�.����??�~��6	�2�jI�:���I�tk�%�Rim�3Ty�5Ӎ�f�nXdl�4�vk��%3��h�5[� ֈi��?dF5L�7��F��\���F$� ��F\�ef#.ٲdgi��q����溈�����}�ӈ.���ٽ��� K1=/۱o��eɥ=��a�F���0�!�ɚ%g4OT4"��<QB#���łF,��k���b�QH4.���H���^u���\�����M^M�X����izy3�8Q7�*Zh�"	0�k�4� 0f�Y6E~f֭�X5-M��O������3���͟���Ԙio�ճ<{��]��z�I�c�)� YR0�-��w�G�`u�,&��S�rh��M�l�^���g�'kGX�h�X�ׇ��T�obkzZ�*z�R�D�㛭���̰|)Ut�ڿժ\�_�e��^j��,g�4U,�M�F�^M��\Sǲ��{R=�cY4�n�l��G�gg�����)���c�>vw�{�K�sʢ(́���{�Rh�f2�{�P��B�����d2����~��֣=�_�e���d1筍�p�ɣ�0^n��B�0�g��n�r��nt��*)$l�MV����6������u����xXFH�D�D�(�j%R�����}0\=õ~�q��f����%��C���$]`�@�ݱG�@��������gm�����kyv'��T�n��b-/YA����	�7Fc�9a�tadG���ٴ�ZA����l^�>���!�N�weԞV '[�;���ȓm�����O����O!Tt%%���͕(��_lw�|9h�xb�E��A�[$�q����?� Oҥ��N�}�!K����9��>w��bɝ�~�93�-�(#PG�Eb3ʿ1<��1~�Y"�ߞ�k{��h����sS$
��b�6����O���eϐތ���3�f,���\W�ý�s1aL7!��Ô��zn���-mS��J̧,�B�!sC�V"�}������w��3\f����I`,�w9/�3ˣ>^Q��e#��[sw`�װ��!����х����:/��������Rͬ��h��۞��ڜ��`���G�����n�z��0��lM��M$����mN�L����_��ta����~m=�_%b�'�ۏ'wT,g5�OJGЇ�a��f� �5�Q�3%~!�Q\��QF`J繹`�Q^���t�v���i�N���Q�r�������5UNV�+Mv&�*=��ݖ$Y����H��{��]"�:��&�$M��絟6IDV��$�*�)r'IDY�N��$ki? ��K�d4���_�p߮	�Lq�)��D���0b1�j�I&b�C��4�v�1�,�gC�D#:2���1�R�|������M4�#��"�M1�l/?���0QF��a+)	q�a���Qr�+뽒l<�c�KV�k�)I�Z2M1݉�K66h��$b�`������,d0m�lN����9J�gf�"ӓ,dz$Y�4����M����O�E�Dt�4�m�K��o�Y���c�/_̧@�P��z�������,������@�*`H�+���^������Q�al���r��);��F�����o�/�w�)R)IDn�i��$b��i<IDrG�T�fI���0'��ɾsPz���ɵ$��3��m�t�D�v��Ddv<vh�x�Oxm.���IMq�q^L���>���ã�M]C����5�`�ܢ/���B�u<�RXHDQǓ*�����˿��|���Dx#�M�J�̕$� ���.�^�DI�Y'/Mj��ة�G�:��S�H�$IAcxN�����Oa�m�?�$��oTL"��D<u�    _HDR���<Q����P���G��MR��i�����|�,I�LV�׮ؐ���2G�#�8>'}�8%!}��9�$)}���D�e��Y�ߖ�{𲳾����t�4z8�PLf������ 2�j��!�����d%h!�d�"̖%�!<3�K�\8�Yz99X4��$L�3qTB��AN����eV�Q�"#�qb��2��j��PTx��=K��5.2�bL�����%��`PS:	�
�0s����8v�QXp�K��H�WpCl��WXZ�Ǖ!çf���q�	z/��?�k�e�r4M���K��>G�^~f|�U]���GWLKa0��u�%��3Qt��{)� ��>k�\Bw1�)+��$�2L֩Ï@�l=�j�Qz����֘T�8�n��)�%4������&&�7����.�`��R��[���!j���X��0#D���^�<�%�ن���\��ϽK��� ��:4�y`<��<��z��0�U�l�|���`�=M��Np����"��ow��CGO��D'��	�/�#:?r8�m����}m*)���"�	�
f}d�P}Kl{�eNZ��[��>BPПl�qQ���W�O�[R�R�ʾ��d^n�m��	���ALC+�����ٰ�7���~R�H�C��j�12*z2���Η���<��]����0�<�K�$M�ex9�sʾ{5;���oo�T!�F�7$���3>(�>A�����!� ��P�K6w�!�N���CD�����r	����H�¶o �`9[�"D��Ў(��n��[ϓg���������|�քn�2+vyp����`�N��CʁK�$A�a��	��4$�<��a*�2����lXc��n�e����{��>��ގ�Lه����[!<߭�y����0�o�NЀx��Qt	���`X�"���M����r�ϬD�oP۳L�*=/=��..��"���"@Oɉ��Y'A��y�$� ų�y���?e��2�����!`�,�]��"r�2Y�s�}�g�6`ↄՋg��� ��,g1�D�Y��ʟ?��B���G#$3(�������f�x�Y��y�/�%Pi�`���ܓ�n�rN����K�(�{u�B�/���^�B^�l��W>�K�p�I,��!�V�3\t ���>�R�Y�u�b�Q�R�������nn��s���������S��|��b�*�њ��AW*����M�T��"6�8@�� (rD�M��̻�(t�����q����c����L�6��a�V���3�G�%�x��V:r@Jp��Y.�<�1����\�׳
��4=d=�HJ���1Ld����]� �;i�f�h��P�Dϊ L2�A�UI&B>��8H�2��d��à~@&6>�N2�!�Qd"�ð�ZX>�ns�ѐ���֯ՙ���n{�,�=�u��q.���׏lJ�ҹ�ڭo��C��5������:U��l2j ��đE�|�?�����ba>Z�ABaI�*'�5��W���`I��Ky3$ѹ���]V�˓�p���<�K�c���<�������b�7���Z-�!/��:Т�����mwZ����e��TD&+òճ��3s����U)Ww�L���8�f��3����9I.�?�[���"}G�.a.��fsѽ'�J�b��0}й���ѓ\�~%K������K�?��<f.�>n�����4��2G.J��QֹX8�$�h���)�=�A�2��1�/�Ŧc�`U�3��E%��9+>���E�_���œ_���(�ܜ�+�1t�4�������vC9��<����K>��?�@��Cd=G�24ñ�4�ȋ�ۜ 1Ѽ|� 1�f�G��J�F�͎5�e�ejK-8�?��X��'Z����R`�&�\�2����hZ�G�$ؼ����X\HE�ꕻl"x֟Ah�ell1����U���q=O�"(���	Z"���&"�W��"n��|���MT�EgD��L-Z#X�#����$NG08�8�:��������#s���@��tH�f�u�W��^�� F�B|�B�^���#[A%�W��P�ط�HA��w���[�0��SZ�� �m�2��ۄ%G�i����<XQ�E��3�*�C��AXDI��AA[Doy9�%#��ė�F4苼Փ��/�~�u��u��1�r��a$�WbSo��mKO�y�\���r6�$(�Ȥ���~\45�� ͐`��2��Ր����B�B��]�Bf,�k��is�A����c"qG�\^̉���=�|�!O�) ���.[�?0�6��a`nK��x�����}���~���U���W�6�]hב$/>0.�Q��R~����7-�"�!��g5&���ƇΝl0J^��Ug��{��í��H��XO��ǫn���B�?^u��#��� ����>�;�7�;֯�� ",�z@@���A�fBԢ�;v�~����"�G�WY���u;_��Z�mou1�1���i��P��m���	̓$�B&���5"[�� !�js��nހ����V>���<��9J"��Mw���+t~�D��ȫ~����$F^�]#��gx1��AYB���W�aݹ�p���x1K3&����.� �������6B$�ܻJBZ�t�BD\z@�$慕��v;� A��s�Ϩ��M�.
%���0��̲�c�Mr�w��蓐}l��A(����"I"�|Cc�Wíˈ�L�j@0t����m�6%˒�Yη9'���g�;�-y��,������/���-��c�>Y���?���x��pv��%6r�@lW�I����JY2���|	�5@��¯�r,.�_"�utH�� c���
-L�;���n�wkd�ZE�&h�`�Qۅ:�X�mf�Z��I4f3��IU+A݄L6����{)~�~�y*��h��!�&�5l�M5y5�W�z��� G�j�u���B��]�4�B��gi,7u!m2����M����VG`�n2Y?�Q)A�d���T�؉lSU@��,�0�C��æԾ!zr� �V�F�j�	�'�)_	�'��.b�D��I�ݴ� ����	j(!W�X��Q��Q��o]G��'�f!�����娅�R^����yA�W�KPKy5�~`N�\�+����X	b)2�f�ޝ��c�I���� "mn�Da}o��� b(nһ��pDQ^����
F˯������^�|k32(�ٹ��#���4P^��q���:�w�7wa ݓ%�&�s�q4Z'�Q:'�7ݑ.=43�����gӢ��%�ο�Ňbԋ���蚼�8I�0�.w����{?m(F�䵆5虼f�@S�(��֦>��F����6<P5y��7K�E�������h��P ���Q7�:�&K��$�e}K�<e�����}�� v֟Bs`d���S	(K��]^�P�w֬�'� ��ΰZٛ� p��*�`��gdR���f�)X	J)�>
)�8_�墌�̘�q���g��*7���u�u
���z)������|���d_[{��t�R^��Vs㈤Z� b$A����s[aD�Z���>y}؅��O^����:q���o�8>Ac������1�5֪F����m�u�RZ�EA���S��QJP*��LR�Z����TJ�1�h�̀J�l�ϒY�񾿏�φ樖L�S���;myD��O�ȗ<3r� �0������ e�ف��6�܍��t�JE���pbMn\j@�ĠU����I���I3v~���pf�����	}�c�����m�h��L'7$�D�+��'h�L���%EDN&���Q;Y�������K���'��k\�z\o�s�FS�Z@�O����(��{�x�a�Or��b�nQ��9_���Z)�o��8_��}��]wy�?[� �Ly��$	���#����h������G+%"��`����*o|�F��Rްnsq�i��)2C@Z�^��E"�Ϩ�����VdR� �q� ��Ȥ�y������%h"��O�k_������~0ص鞠�2����(�    h{_�Dy�>�X�dQ���,�����?��r~m�w��Z ��&��]�(�����SdZ)o��	�)n	Nu��l���JC@��D��-DI�Th,�tm\����)��!��:�U�߅=%���U���ռ3:*o��_I�u�'\L` �2�?Y�~�G�+��d�jSsƛv��rV�l���Q��V��ӛ��h�?����/VS$��4��
Y��|�J+��?Q�BZ�xJ�	Z+�L\�3�(ܷ��|@Y�̶ c�7Vݬ3��Y�������~��� B��M�=�O�l��a� 	�B����3Z����S�(�`��7���62��"�h�YnTtZ�C�IH/ZQ[�q�b@�%Z����D$[���Pؽ�L�d:��T�2g�A3ٹ@��$mQ4��Ah�DdU��:�d͢u������MPq�hA���I���.o���	�.@:aY��l�ʞA�.\� A�%��'h�0�v6�*/��(�.�bċ��"Ǐ�3��a�	
/PG��E���:�'�7�Ƌ�h�D�B�U�]&�<�/˗v?�ɛ�_�Y����_�,�V�Z0d�aF��6x����0��x�;D&�b�o�.̛Cۇ�=�7!���X�"�4�OƯ������`���}ˁ��c���iL���l��7Q~YX����W�Q~YX_)E�e�j�/S�*4_�u.nJ6�G�%h��a��_�_�r�i��_���[��ȡX]v�q����91T_dd_��wG#�"��?˔��ף1w�������>�}!�Q�3�0�UL���8?�d��'�����Zz�
<�`��»�nq���[�����o��f��>V����0BC=�m�	�q	�1o��"tc=�͌P߶�nJi$:���ݘt��svE���[�k8_/AMxPV���ѓƧx�^�h��a�Gtc�2��s����lV��>y���A� $3Տo�������V����v/�]�Bt�2o�I�uV,H�X�mg���X�m�c|;�鑗��!k��t�޴��1��?��{ў���}��X`�P��[\��y۝�p��
�O�-`�H=�h����u����J�&�a؅9h�h̬EDg�n��R<�3o7�:|*hϼ/*��`��B���Ns��L|���i�o�i�	�4o��!L-�������~(ռ儹SA��V��2��,�jd��Y���b53^�D�f:�0A�F?ng� u�̝���5d�$!
6B��E����=�ր�	͚��x�l͌�/�k޲3�uz�k<��� Y3���S#0���荳���k�9�6ϗ�0!4jy�����۟t䆪t^.�_���a7-��W�̍����E���Co;o��kt���p�!�����B����Yd�0��O�.��u�r2o�|!�n��㎳�������Q@�zEƗo~l<�7��k�5�H�L����x��ģ`�n��v�q+p�2�c�o�b����4':7X45���~���C�U��/�1@���;(��o�@�ƑF���V�6�x|��
� ���	��e�Y�v��*�]�ٛ�8���� ț%�� �����1�[��d�]�I��.��w�f}	���	� =�f�u� R3o9�P�"�̀��c���XH`��R\�BWƠ1P�!¸��q(����68Д��ꐍ�u~'-w����G:��N��$S�bH�8`�0-�F���KPD ��HÜ�j�gzNш��Mn���U���P�`|�)R1��y�(���<E-�8���Т3�+�)�1S��3Jю	f���7�dVtc&�,i�'^\ߏ([�(��(��Z��w���V��48^c�u]���	��JKьq��yF0x���(�vz�����/�tз���6R�a@:~0E&�8�Lщ�QQ�):1oQ��o�`�p
�˭�#�@�P�ۑ9NЃpڨsˡ���!K��Y��H��
#����� '��ڟl�)��_#�#�d�\�AI!��������)1o��iq'E�����e�����!��Rp>�������x��<����ؼӞ��CwX�c��ܒ��F��a�*�,E��6ϱ����ܜ�qI��0\��pZ��<�om�Φ�Gh�Շ8����øm{���K���U���y#�KT�>�0.iF�j%@�q�e�R�'.u<;�-��?$#�K���d��m�{:%}�Fɸ�BK)-������B����F`�l�.o�z#\��#WR�Y.o{����N;)�,Bԏ&U���dJ��7��n�J�����8Яc�T�ۦ¿ʉ��F�E ���"�b�в��bh��*Kް�~*|�>E}��?��v�W��Fy���3�"��4���Z��%��"�E-z+�[����O��(��"����)4�����J�XjGl��ʥz!*A*�N���U򻦩��V�9<�?掞�X��H�`��jRdU�8��a����n�q4U.�����r�/|yek̓U�m��ex�֚_�լ��r��,c��wR��ZS�)Z(��4�u���\v{��'�����Ѷd��h��Դ^o�?X�-��@�@��)J'�ح���w9������VeRTO�1َ��d����q������)���M�I�
/���C�%,��H����S*pv�g39U�2�]��{�k�c=/� �Dʕ�73��u[�/SG�W�-����Zk�I�=���a��dv���L�r�d�ȉ�����ZOĚl٧�X{-Ï��g�RdN0ݲB��rb�鷑�Z�m A�m�K���"lr9��H�\n�^n�$�5[�U�km~!ݐVՠ�&���4��[?6E�đ^���vԷMӽ�����!��-�N�``�f��+KtqO����n�g#E��L�� b2�i�wk��|�X�����C��@@p��ݞ7��j�S��/l�y�ٍ9�S��nj�>Q�M�q
i������m���=D�Ē�\(���Q�K�<�1E�h�z��	�~OG	9�Ҵ�Jo��"rR$M���B����K9L������]JΧ��\�MS����>�wCr��)�%1�9E��RJ��h)%�C��*��p�I�	P$�j4� ��w����h�d�?Ex���� <r�~)�#��	�I�1����|�/��<1�"*�r(���l�F*ȋ,�a�-EgdiW��3~}!3�<i��5r���k��C��߇�B�/����"7r9?mzzo��\:��$b��h���-��&}?��I{��G)� K�ch�1� ��>LO�ȁ\�OR5�v|MK�i�e�ӎ)� nr�@��;jH�\>�p�A.c�m�Kz���4�!K�1�E�2v|�8�p*��;SS4A.��E�˃���LI�5Q݃v�Щ����e�#�qi}�njjP���nyJ���#4?.9d�=�})���C;�C�h~\��A�}j�_n>vo��8��Ó��>nB�C��K�-�_?m�C��k��KS}
�6���<��hܡ!^�򯢑/k��=�����Rt=Cv�z��6�9���0j^,E�#B�����S����{�KO����P��({\���!)rt}�ϼ�=��(	�n����$���'yD\>)r~E����YyREK�UfC�� Δ�h�~0�RO�Ө)�ʐ�i�`W#Ձ)4�hu�#N�^�sZ�}q�Sy��RT6 6K<�B�\�9u���,s$)���l�K�3�\���ha�I��g�hJоp;?��u�֣�$���C�B=�<[�|	��+b�T�7����O�Pq�+�ѧ��V�F$�R8d�1E�"@u@��?�t��04ܪN���wH}
r�^9y�W�a
�8�(Sz�.W��.S��E��wz�e�`��_�K�|n@�0���'{q>��t����sФ�R��w��RR(����*b�'O�q�F�5��&-�cպ�X���%�ܥ~-RA_Bp?�ؕ���-� �u��;]e��Gâ�y���;������:Wz8N �    @V7��3'���*��������%ɼ��:"s�Q�9Lݑ�a������/��E��1yi��2�݅�Yb?�O���g�=�3������NF����y��;I�ϝ#8)͝ t��Ν#�1M���RiOs'
���k����i��Pr熃�ڹS�a��Hsg��22O��;-��
��>y�;- ��f����8=D��$���N�Y8)@������1w6�2O�;H�5͝�kN�C�;x�ʝ ��N�As�!x*F�Cz� ���ޏ8Isq�f�tq���䢅>|��X�e!��r����E.
��j���j���7�����������c�\-�Hs�����������ڏӇ����%W��[2�\�����qzn����I�7������KƩG�.|f��^	h����J#?�@�(*�'@�0��Ze]��ŗ��/(*��+w -�sX
�E��^�c�f}�Tkף繕5�W,��THkٯ�_���Mp��Te���ǋ�+�r�wq���9Ve@��:E2�*ܠV��z��"�������`��֫m�Nh9�D���H��M:\)Z�>:R�36K�k���[����Oݜ��z�_4�c�ؤ��tR���l�f�)b.��)
!t�b�!� ���.7M����H!DCL"�F��!����u�����D��]G n�u-E�
YwV�S��b���]h�A�j53H#�8��\^eI�sX�J�C��\��C���ҁF?�#E� B�PX�������?��w��8����4�P�@����{���p�9(��B��+N~V�A� �{h�FH��W015������"up唫7���k��ń槛���ʄ���֢|�m�px�����W!c�S�������L7��z�G�=���Q����H�V����V�(�{��O9�i��t�'���d���w��!lp�"bW��$E��tl0P����N��whcQ*�Ԡ�
PG�l�P)�R�<��zg}?$
��ч�xA�_d��ۥ���n�3A��a A0��H�I�#��X(�U+���1u)bn��8�Z�a=Bۣ�,�WG�(@�=���@hQ0� u;��NS4�>n�pE�<�aU�o'�~�O�7E��@�\��/úu1:��a99�+uz_EKએ�,t��6�  ��:�t��I�=���`��:Sd�I��)� n�ֺQ��C�_�*���������b�pc�!VOPp㻎 �y�3%�a�`�9)� n�ȹ}�����\�h�)� ��[�S���]{;���t����)
������D@��w�rӎw"�(�S��$E��p5���~�逸}�U!���>E���S7~ŔL�]��V_���:��"lݤ��"���f���C��?��ܵ;,<��<� ��� p5<��В& ���];E�jl� ���x|C�@0ZL���4�f����q��{"��8]�'�{�1�wx¹�o�^b7$��]��|�p8-%�?�B<d��v��7�Q�F|� b��F�m����o�;m� �j���h�Hb��肗�|��[��4��  )�8N���|�I��#t��%m�`�ч���i<�^[��%z ���u�RB�I�Y'���@J�-�����z߁�}�G�{���%�����Yt$	п�1�ɿ���66�ڹxXJ����n�C0%��������_���p7?W#�k���L8���\� %�>��^ �꽑�u{�c`S��=c�d�u݊�ӊ<�:��� LM4g�����ں)��~�fJ ��S��hz�謓�cKh�g����w��u-�p����6�~�^��j����)���6遥��O��S�y�iV�5H/���O�gg����O������݅��g�H�Ϲ/%���?�n��#P2)� %H2͗�g��P-h�ٸ�G��6�n	*J�֟��1]?����
w!/�/h���H��隸���������"&߳}�A��?7�����8�I�L&U����?vk���O�nAD]J�>6�"q��s#>?��{ T?n�$B��7�3Z!D�$R�R��g�������Ȗ ��ř�����L��&mՔ�{,N���y�@�� �l�S�p���3wP!�'iϤDכ-<�?�a�Nt���4z@���hoFx���k+�e���)Q��-����֑}�qG����?��>A����yv��	�s�b���܄�/��R�����"�����~�� 9�J� %���]�V8κLD޻Նx���tx��T������D�r��2�=�~
�H���9�Ѣ��E�S��;�5b!v۬�q���������=C��u��l�r�Tӽ�M��5
j���o�.���u��z����-H	�X���q���~^=�hbݳD,��c�g3b�()1������-�O	����v�k�`B��J��_��
�	��+�ԛu����X�U�x��nC ��Y�4��'Q�:�6���u)��4�_1��l~�
熭�D�_��
'|	֠���k����:\�������[Ki-���?�i`��;#��z�uE=�S]�[��_|�z�p��)C�ː��m8t��Zi��9�N	��V�O�����'���� ^��.��'oH&:����@��L~�`�������̙��c�[lA�SL�˦��n|}�6�3��y�#F��Ǩ9��FI��+���S������x�0d"*�zDۀ�<��	��6�������op!՚=�Ⓚ��G8�H� ���J�VMNCIfX^����) ="ޕ��!a� �oC����P��(��y�!����e����7��gS��7�:�		^�$�_p"`]��˔�u�m�=��{�ND�kΝh�q�:�J���g�#\}��'N= ]B~��f�rM����h���D��|���-?" %�܀���c/(�g��؜�����u�<X�=a�ǸnM��M��,ppR����6Q���S;L��e)Y���JS�2�N;��c�a-dK�A���a� &�<`_##����1:��*�.����I� wS�lB�ӯ�ocow�Y�qD��Am)��,
�Ofj��Q��J�L��Mw"���<^Nj�)�7��������D�߰�C��qk�[e���H���ͩBչ�������K�Ua�n�e�����xc�|ܡD�x4�ߛ�0��ܑ&�a�\y��a�
4�Lu��=y+τ�c�tAJ�����M�0L{4n�_��q�>l��qZUJ�x�}�(*�Ń���P,L��)>YN�G�grت�:�Ĉ߰����`**1�7<��#n#�
�
CM	��\3�]�d4�"<H�'<����	`��">�ǵ�]�"Z��ʀ��E�GP��o�D�	z��o|�eK�1�;��GD-&����b`�?������@�i�V��ݳ���nR�o?hկI�?�Xl2w�ٖG��&s�(W�Ω�;� �����sX�P�S���6b��z��l�X����DclY������G��)�}#.��|}��Y�`��i#&A�õ�Y��ܑ[̹�h��kD1�:�󤍸&�?}n�-'p�+G�<[#��nD9����x���R#�1����-�Yy6���+�CD�A7��f��l2��i+Q#�9��<�;�-uM�>[�pw�\�K�ԹnJ�;�I�sSvM�o�5�����=[4pNXFC��t���T�z4M�D� �r?��m*��qq	y��Q��/���HD9�ſ�W4���I!�EA.�2@Lt��I��d��EI!��	��y�F�t�m��t�
@�>����AK���ld�-�����rJ�-i�6��n�K��S�)J:��|~fkڈ�N�U#~␖A߅���ƱG#v:����G�	�ϓkd+Q�|�p�#�fi�l%B:�i�p<[��N����l%::��|bx    �'�����I����o[�f�V"'E�f+Q�KLe+q��'�����6�Jtt�9��J|t�G�}�E�V�SSH`�݀B�&[����_��%����K�p�t�/��.[��N�!�V�%�y����N'�f+�ix����N-f�?��V�� �J|uR�q�O��뽈��kJ?G�]��y�i�CI�%[��ƹ��Vb���۸l%�r=�l%��:�e�s}�]o�l�#[����~��ź��'^fD���.#�����]ݝ�
�JF(���Y��P� ���鹩�Ǩ�B �Q����P#ψ�a���ju��m�Q�7�pxF ��.�
�D�Ē�~�Gp�=���4�#Ū0�Έ����:ܘ�h����B9n���wd�}�}�{��2��@���3��-�k*��o��"�n�^�b�W�"�Nda�p�����R����p�Fv�)��L��z��gĉ��
>
hv�'n��D��X�}|�A�N̩E�ی�q,�UB
�͈�7�A��o^�pe�/@��j��Q�W~��r3��=�����N�U]E�ly�:X�d�;��@�n1a�/wl��q�v��I��VEwY*��eġ�y��pe���~SMh�ޞ���'޸�>����M���u�������Q�vx:S:���?��C��ɈK7�o����ᎣS2��o��N��VIsd����pt���7����t|WF`���{�[FP��S\qĂC_���RZ�>�NF`���(����ZhT��/}$��;7�~3h7 ��k�YFX��/�Fw�d8ے�Ջ�=���L?@�B�2b���ˈQ����@�����H�4��B��f+���T���g�C}��k3R\�͈Yn)�,˶�h��yޙ�n�eU]cǌ0��̩_���<O�Q��2o3O�L=�<�xh��=t��T�G�d��� ;#B�3��j���p)�:b��z6lÿ6�ɏ�����)��W�̈�9ZQ��ױQ_4#j�M?��>��nA�&#h��;�;fDλ��3�����,��&������S����]����D��Ԇm/�.8X��R��2Zt��Lչ�~��D����ҋ��=-C�Z�E{O�=�Q;# aX>h���?��2d������4�dFX>����[�\�oȵz2��oX�8� >C��KP�Lg8��Z�A��#�pB���gU!�14Bj������E^���ͬ���)3���q�����o<�����oVs��u���06��w���N� A��4��
K("ejT���Ld��q!������N��Ǡ�����5����'!�7�c;���3#���~��Ō�~��g��@�`lK�R�2���^���Uc�w"����*+0���~�V��.A�z�<����	2"��q��լG�uH�#P�E���l�5�;g����e��ߌ�����/6�d���M��Ѱw"#�p���C�����J���ݍ^�����@��d�-�m
[D�g�܌'���P �r MKN� 7�#�UL�d��k��>��	x�J�"C"�����{ge��M��OC0Ֆ��%��& �2����T$��w���3����c!����y��Η�2T ޵�}�<ǳ��oF��:z/�j	�&��e��8�HD�̸HȪf� G��8��j)Ϝ��wcd���[��6zz��4�N���}���G���n=&C/�A�]�'d���_�vd�"(�g���7l3&|�~YbZ��%<g�J��"�η!�?��~o���i""��E���	��|��b}�xGC��;���ϻ�VCOD�������$q?�&CW�ݠ3���w��Ž̭�� �G1�����3!��Y��:�<��sw�x�ϙ�ܩ��yvw�d��)w��u�<�5�i�C����~�Z�Q��?��U�O��!�!t �����7�97I���?�f��s����榧ICΖ�]�tMvn�ݐM2wwḴ������؈X����B�����g�4��>({:'����o[�,D��_�	n�����"��'�j�!���~;��?BQ�ޫph,ˎ�����a�yCpa�3�h/�����he*텀}w6�P0�G,�L�d��`����G��8��������U�gFo9Y!����ǰ�(C��/�!/���P8�P�x�L�x�sK(�����C���q�ij�rp���\�tp��~�f�̑��2��N<�,��~��Âu���Ҳ��"��y�*O����0�BD����L�&Ѧ�(���>n,�*Z��:n�'��bL{�2� �4>��0�GBF���C"XS�HBLV-TeC��3���Q�އka���zw��iE(B���3�R�|�A��Ϧ<������P>7TKó)S�$��Ə�e�����ȅ�P��FϻLf�ԋʄ����=@n­��P��p��2�&ܪ�1"3^�y�!4�,�T�2��F1]�eBq"��F;hN�eP�d��W]��z���(P���
U�Bh������)N6˪b�x��*����V�_�3����*F]L]���]mp(ͧ�V֡�z(�:��:����	<�C)�Y����:���;�{���!x��=���ۏLn&�Pɲ��!���*Kp�����{QY`mU�kX[��i�m?�(˜��if-sz�0���Ugh�,�nf�=��и��:==˝���x�=��Mo�I��N̓����j���,8���/l�_��g�ŷ�����l����T]�W�\�h2m����$�,��fy�u���<	���<	������w�|R�Y�9yR>˚�-y���c5˘'�0+<G�B)>v{V�C�3OCA|m�p��i��E��~Xq���|�X�p!�,OC!?�q���;���	ȝ����t#2�6���m�n�������Pװ���2�5�>CQ���s���2�5�#�(JEW���U� Q�����p͘��������K�/����S��� ��!�q���j�
F��{5�Mo������$*d�mq�����A�q�zN#�!��ߧ��2<"�����ݟα�P�P���<q�7/V�D^�yD����eC�c�`��K��%�9��T�"w��AQ�x�=G����aN���:��;(���F�ZW1ϧ/��� �0}��a��5C��{��x-������<������e������9t?,��4ΠȐ!���>�p�\����c�)&�>��^�L������J0G�-!ލG��5G��+�;@��=���@-����^߅Q'��C������Jq���-����-���AJ��*��3C�ܐ�፷�u�Џ-�����e�+��sj3�?�7^7�Y-�Ӎ�yNl^��,c�wㅈ�K0W��2<�Z�E�C�n;#2P%�E�ʨR`���H�A>�}�� K�2�ה���F�~��L���%ß��A���g���U��l���,[l��K,$�qԯp�;^#E�Xȇ���g��|�.�����C�-C&���^��/�I-���	��JˌW�g(�|h�t��[FdB>�R�dB�`2��KGd�1Q!ڰu�������=G#DI4��+a�k�V��PHDS����8��������E:i����!"� 	�%*'4��#!2[��\d���Y���5K�����|�	����'�������(�D��e.��z�"���U<�EB���|*�46B[D6f����3TFdҌ5J#K��3�h�8V�wyq)�:�ZW�ܮݪF��[���vk�����/ 6����1�A����IH�|����z����g_�׾�o�u���}q�dJ�������1�j�h���=��_Y��"#B������-���U�0tDad��Z]e�yB:�Y�-Cpc��]U��tF�ќ�3�h��f��ՄT�����:YdL��������ٙqY�j����z!?�A��<��=�h��Ao�kw\C'TG�J�ވ�Y��_�    I��S��
O��qܻ�j��H��yS|w�+�h�h����Q5�=�ϊ��X7Y��^��q�
^�OP���ACd��]�k�+w�NF�rצ��_��\�KO�vw�]�Aw�
o��Lܙ��R�wwɗn݇5�R䃁�y���g����~Kq�5*��K�Ϭ萕b!���Ɩ⟃�q�gd�H��)���d)�9�Y�n�
S�q��p��B)ޡK� �X���&�J���2�� g��Ǘ	��h��K���S��_�n�U������3TL�"����3�I�̝�g���u6]n�ښ��
��(�$����p�s�s��W���J�*�-�u%�˩a���%ke��I����� Bʝ���VI Hbo���R�;�^����L*�R�Eyr'K���,��V{Е��{Ҕ��%5ĢJb��(K���J�9�m!!�(����:*��VQ��խ&�i%�8fg,q�H�����+	-QH�ޗ����7����Z�Jb��gY��y�r$�qԥ��3B��K�%���o�6�g�H4J��;f��ģ�^3Ep#��w����*��@3^���J�(�F�u�P4ntQyYIeu���Dj^%g/�(Z�Ԓ�@�ؾ�VI(�O�e���U؃�씱6^�ZG<��z�Tu�5���!�^
�ò�/ɾT�t�MYIT�]W�JTKy�%�|��J@$J4�/�!�\t���+a|wv�tCoDI)%�9�� ����Lf�-�m?���W�sL�ɔr�����=�JH"꼗Q!���$��B���j v��DT
� U"�
����%��������@f�
k�� � �u��'I�W⮂"��G�T�hq���A�x��lM��=���	[@!���K-�_� $�IS %D��T�Z����M�������Yւ!5^�f��S`��&��,G	4ċ��:��K/���z�
��a��JP%�z�Z8�8�DD%O�(���w�,A�������/'L��𫯇s����+i�s�Yύ��}u��ȅ�5�m@��v����`�ME���^�%����Nʶ�?B���$r����g˗�<���!�!���ar"��rt!�1e2�,����� tt�(�Q>�z���~��-�B��2�L��H"��=��́��%�׊��c!�S8�&�A.���~'n�uX�<y� b�}-,�&�*�@<���2�xEzhA���9��^���5����@��=$h ��ɸgț DT�\�\z&Ĩ�<ďٔTJO$g	��B7a+�|\��Ά��M�b��#�\�Y�
�#�I�W����u齃�p%�m�!��)q��t懟��#Z=�U#�IEߩ�����I����aed]��i��x��(s� |�%<�N&4MB2T������}��t�!��	H�{�A7?	��~�	�� D"l�P@��ua��O��%0'<��z$�����56[�L�	D?+�'0�A�'\f� *IsDM�i�
�	R^��ZJꗲ-M0e�=���!�Dje		$X�;/x Q�� A�F=,��~� @�aK��?hR�c|P��\�{��O�r�!.ȅ�� ��pA�<N{���AT�2�֧�j����#�A.��� b)Ļ"�(0�6ȅ��D��!� �(�
�$փ��c���[�}Z4z�rz� B�����ڂ��F˥i\��Ҳ�󄘕7}DZ@� b�t-� ���R�� b���p�Y-�hKH!j2�6ȅ�w����2�$Xޭ���r� R��%e��%0a��H	D�i�0p�6�"L� b��(a�`ip⬧@�(a�\��(J� �=�o��0s�y5��j$�{��c���H�����Fb̸��ǉ.�B�"bˆQ��H�۝@��%���츢KΔ�\�ͫ�2<��"�$�rfъs
��D1i�.NՐ���W)�d��Q��x#����A.���*�A��ԝ�ʷ��g
�0x�&�e"^˂�p�/��^G�AKN�����B\ ?D%��
�����F�!�x%���A��FG�!�#{y?6�B�W+�\��'N���6[9�)��5����f��}t� j�D��+A��i�ș0���К/ ��r!��D���"��c�Qc�UH��m'De����^�Fl���\�W$8�Ebg-ؐ�ӷ�D�$��Qg��I�/p"j��(<�.�Rz���	yPE��=���B�h�������G!��ET��˷u���u ����4�j$��9�F�q'fL2]H#�\�[t�P�}��~��w��G��^"�NH�vl�u�?�|5�"�@�c�C.:E�����o���M�c9ڙ�^a�8q�Q0("�/������Y H%`զ�P�E���Zo��W����"k�Y�
L�k�%�(ͤ�Ά3�Y�'V�(�2��ϵ4~`FT�ɶ��N76d��ΈJo�MϏW&
!�Z�����x�W�#��t��*��W�Q�C��xa��Wo�GTc͊�kn�:�[�%��ɖY5����c/ʯ,@$��Mi�J�Ϋ�Q�4 %Q%��H��p I�}I����'%Q�G�X��D��V�{U8�Á
#Gi���ñ����(��Ge+a���=$�V"���^c���i%
���	�(��<S�}�!�;F�V��f����Ȁ��%ȑ�j��Di�%9Lo$��B2f@�ȇ�x�J6?���B�+�W��60H(�>r���aNwD��h#�y'��� A�euD�_B9�R���B��u�_�m0�G�ϿP��K�M=��vs��ğ������Ҁ+9����;�q��.I<ou~�X�I���;
Ǭ
~�� ����r-�Y] 6�H��<����n���F��B�����w���r���kV�2 Q��gֽ���_賳�G��F�٩��=X::j��$���(8f'}EO�3(gg|�.*��_��)��v�g�����n�6+)��o�f;3���$���RĤ����=H�	�{���� Y񒆬��:1�\�;���h�~w�����LEݿ�a��E�d�Uvř[�9`s
Ó�11�W����C?�ǎ��kZC��n8,^�������L��L�60X.��Q����ťL��7�W�Wñ�����h�F���N�Er���1\<�%�����>�Ҋ�N4�VĤ�.��]�1�ڻ��w���"��i"�D9�;��o� ����Ѳ0���X�$���@Y	�Ts���tm���5��6r�ԕ?f<��Sq��/p1U&{J�p��Y�����'��bR�~Co���;�������<��S���n{��?����#��P�>y�b�8��j�r4���o��V�.!�9���~>����ސ0h���}��r~q)��Ųj1��MDU\j` �\�V�{K�iq�֫��d5U���2`U��/��6��1PU.	��B� V3f��L�K���`-n�r��*nE��� W.W�&����9y��\vw�(+/���n�?�3.��c�P��.�^����1�V��+��ܮ{�0@WR�Keǽ{H�om�y����~���r�=v�n�
�Q,U"�v���?�(�cr�AdA�Q�����[A��+^��+����Qι�����I��ʥ�u�Ft%��1�V��'�+H��b���邜��(SGl1`�8�iEk�MAݣ"�>�F
{�m)��`��z�m-�u9jr�\���W�Z{.P��2Z2$�#�I��\3�DnE�R��1 UR=n>h`��xA�T����235��V�@T�/����vU�HX�\dr����W	^�.|^m䉲&�#���Z�{�V#�Tkef�Y1���V���y080���]�������"F���;6�U��mPo�T������I吏�WIe�20VT�[��'Sg7�ڤ�O��L�K�׫�G_�z��6Z�z���J�T�ʤ��c]�^���ɀ]�������2s�6� `I�i����2�B�.ˤ��^<K"�[�e#�׀k�    �����p�C��z<�،5��ê�{��vk�>�4x'��M/wWӨ�,'޴b}힁��O�Pa�b,��/r[$���jKu�+ߚ̶�=��7 X��"m�e��z�Zr��0���ց�23��߸+�$�]7�A4��a,��g	�_Td������@k	�02P[.�V^C��&H?��]��r��Ҧ6��b���̍1�\�� x.^�w!,��Ƞ�����[h.��x3�\����KP��o	�%h�� 邨�˱���Ae@�x��<c�%yKn`�Lv��uIS+���A�`~а�EMɦ�`B��g�KP�\�M-���.��j��"'��l����i��"��2Ӏz��S�[��,&�����0Zh��ɓQ-�ԙ�h�/���F|5��E���u�0ZT}5b
SO�v4'��)L��+$�N9E!17�g��Z���E!�ѝBB����V	��x�H,���e@֋7��$��w�'+�/�!-����?$t��J�΃|�T����r9ld���r��,�R_`Pƍn�o��g�H��]��p���M<�"�oT�lM� ��{�k"���=���h/*�P �咕�D�g_��7z���(�A�"�/q&���,�ưe��29h����
-�}��%���"�14oD��~���%��w�FFA�8��e݉ي����
�åf�r��*��DހT���eO%�WW�;_�.b]����h�L}]����;�S���	�)W�u���)W�G¼u�a!��)WJ�5 R�V�tNa�\����Q���m�õ���ELђ"��P�Pt�5�e�ef��Ƅ�b/�/�L��4i�羔r�#�J��?�󹧼�F=Sy�R��H����Q�T�&��5�kr%����rfI���������+�ċ�q�L�0�L�̖���H�$	D/N�N�߃�@4���ɀ5Q1G�&�ܺN0`���tW�X&Z�Uf����@�c��\�#wbr����/Q�_�d �8s��p�~�Ӓ6	��(���`�G�&��+=s�%�����.�2�%J�xs��:�%^ڰɘ��&�����U��0�KN�e��ɓ�I���X���n��:S��yr��h�?9u�ճ������͠P�_ߗ(AaC��*ԅ�H�(�&��֡���3Z�iZ��zq+sƫ��	����\UsG��p�ڽ�2�۹]/[ /�h��e�g�n�e/E]d�Y� h�ܝ����7��4@Tf���i5����z�{��3��u��d�.� X�`jT�Y��T�}�c�9�Y=�l�xG�4E�����Ab�;Cz�e�Ic�,s�^��deTP-3m�&��&��w���o�~��X*��ίU6P\T|+�s����uh��#|i[�z2��@w�����p�oB���δ�KsS��d�w�oX�8�=�ǘ��DY�(ŉRΔ�*��|m�E8�w;���,�\�s�Ʌp
ፕY.N��LII�,N\Iw�,É�{n����9q�F�,�y�0ndc��̒-�Y��{��c1��D	'�vz����̅"�\0�0�0��94�}�W����SԹ'�Cќ��
g��h�\�b|L��|re�e*HcI�Ɣ&���S��35Ħ�2�!L�;���n�Zv4�lr�ݱ�M�l�>��c�x�4���w�����]�ҙ"���`���3Vc̉G����06wN���1�z�cfU�R���o�11����醉i��tK"cb�Ŭe31�~�11�
�I�){01�R=N�4&&Q�㚲���\���c�4�	4���ݿT11�
��
ƌ���l>s��{we`�TE�A�o%R����>��ʜ8����T6�_��Ƶ��U���[��s���7+-n������a�Oc��ԑ����p��IX���~��_�B��z�k�>LL��g܏��U��f)&\ANk$&]�_lb�u͚`J�+Qt����j&��,J9Sf�Ө�����DM���1�w����؜�\���]�s�V�q/O�)͘�8���b����1�
����]���i&�W�v��J�&yx	��z���n�%�!�R3��7ِX�|�s�?�8ڐa�t)�;�S��	S`lȳ���f�,�	߬�`좚�ѱ�:u�~+(�]4��-�y���M�!Cv�H=�<����r����,R���T/S}���إ�{bX�K;��0v9;i�~Z��9GZ����Y�v�.g'�oj�\��8#�[�N��I��e�"=o�����	�E9�|�s�lH��,�7��6L�>��T�_=��D+6h�'fq���>+�y�{���=�nK��}�p�b�,�5��h�7�d>G㥖������g���>)K��+/�{�(Z�ӯ��-�L{-����4�3n�Ņsy�	bdF���8���b�5�;q�Ɯ|`j6��g��>�XS�q��w��r}�멶ƚ��t�*���5��5������Y�2�_��i�ɺ��q������j�����֚4=��η>���dT{Zk�������֤1���}ZmQ�X{Zo�)j�=Wq~��V���}��s�a��\�ɓ��\})����\u%�Yu����[����<���\�� ���Kf
ܭ�/�sUY��V�*�z�wB}���al}��ұ[�jǃ�N*�}�P=߹��7��u���<u��~�ʴ���C5L{q[�3��Z�ΥYt�Ia�����Q��\9-��s�vܺ;ɝ�_s�K.�JqTM_��:��ِ����^V���@̚�mbs�)��������c�n���|R����$���9��璯���FZ�6������T��K���p���t��aqyq�i�Nu/m:4�ɞ��Asy�j6<
��J'Cu��P�L�������G���k��w�e*0�LhS!5����?�I��5���t��/�}�x����$�W�(��4��=��S�>����lb`�e�4v�~����a'n����s>M����8��؉�?*��N|~}Ա��|�+��bO�5M*L���f/_!�%7�׫��ۆI���pp��gV�e�;��uܲ�����䉇f�y��? 3�2I��-����fP�>�����1;Ֆg��Vf�pl�1c��9;cc�|,$�P�N�<��=mT��O�g��9����䡱y�Php�z�ڼ����h�j�ΰ����v�=�t�ک?}r�i��!�k�N?@
��3\
{Z[�Ѳ���_��{�4 f˕�L���t�?�-w�W���ө|e�
��+;S�{<��@r�;g�dU�xy�)-t�O��&��K�mw.��e�g�P%{��ߺ�Sw2�F܉?\�ڜ�X�Sg����;��"��;�O�
|���5������9��w{�խh�LK�E��%�̛*dy�6����Qǥ��ڝ��}�D�DO?r�oq�*S��ϻ�$o�g�'=�� N�i��
I`t��ҝ��L��SH��i���~�8��d�([��Wj���}���Q�qpöyE�����pB�y�E^�����(����y��}�E����z1�	<�����>&��<��r5�b^����O�u�6%��9��4n�E��B�^.N<�,��婇ѺzYd�X2��2wj�Z/M����k�Q/m�LF�eu�<v;�y��f�^���30�2��?��.����u�WH���ĳEe�\]��ƺ�k�bؼ�v�Y$Ry������3u�W���n|��y�\��7u�W��Һ�+亗�ku��Gؑ��eV̒�~q]�*��+F����YU$;���u�{����3%i���\.=����u��7uO�(v������,f�t�e�Hɵ�6���ڔ��ߘ��z��E��ͽC�2�K�i�m��/�����LS����I��=џ��]d���A���.3��J�Զ�<�w����dzQT۬Zfm���3��U�y��NG_�׶�<��(���&�~��;��f��2u��}q%w]-3�_����\72#���u2��+�y";�ԕ�}�f�����}��A���=���Lȫ�&��7���<��'����;�4޺^�N������ı���X]��ɻ�    �y�L��N�{�_�W�봭d\]��fu�u^���2k�ʼ2޹;`=H�[�ymL�#�&�|X��6�g~c)S7y������C��1u��FM^1�4ye\���ɫ"Y�U7yM$S�&��$}�ۼ*b�j�o��6��Tm^`O~0�?&Q�Y�^��O��*w~�:�NA�so�a�ms�bs^!5��mso�Y�f��}Kෘ1�b�B�٦����iB���	�'���Y4�iS�ބ�s��iu���ӭ&d�3g�㚐�μrE�����;�&d����r�!�;N�=2J����nYC4!�|?�x��n�?`z�(�	٦�d��c�z�	I���g�f2�G�	yf�eg?%�)����?�+��G(�����4!�t���&���	9䇕�E�&���Tϥ������!�(_٦B^5!c��z�C���Z"� ��'��r��C�ӄD1���5!i�ރ�ܔ<$��+�M����̋iB�<�e�	d�^kR���j�Y�η��j�Ā������W��F�E�4Ɯq�������6��}�6u��Vk�I��p��uR/ɨqc�ʙZ���u��JlBf�7pG�uB&��D�&䑲� �M�����1�n0m�g��<z'�R!c�	����e��/;�
�ҽv��&���fゆx���M�$z���Ybtx�iB�<�3Ibdٿ٬_��i+������(P��j2�t7Um�ҞSS/2�Ԋ�����<�K��.O|4+����qOr����������U��;{�&��ʅAh��o���*��4!/�>"���=�+����;��ل��2̲hBJx9l���TP��b��N^5!�!�n������'4��W�-t�7SH�b��r/o%ؙ&����&��G�V=���O��&M�
�^���RMH�Ou�{,p/}�C��~̳�L��̩m~{RiZ�r��'�����LM�ָ]���t�]��Dm����L���vq��~�U�8S����]�����q2T�8[7�;�ӱi���ܡ�z��ېKF!d����#�;�<�!���iwm�%��G�d�q����c�����ÆTͥ��!Ct�½Yb���3��:�h�6����ZG-ې&J1S�'��at%}�6d��S
����G�Wf�腒�O��V�2>u���[���3��a|�d���)��2��/`Z�����'�̲њJ.�����X�=F��ODZ�t躰ġV&�ǣl�cZ�S��A+��/̶z�m/5,S`nZ� xde�G1)̨kU[�8�]&b�le���m��Oy�Ȏ���a�bu����X]��!��P�� ��0ƌf�u�=���-@��Oh�v�ȶ+��Uw������T�N��[�?bP����eP��U���K�Ͻb)ڇ���C]4�P܍'з@�F'o+)���\H�e�'M7C6u�����^ާ�|o}@z��#M�����������.��
�nP���gcݝ;.���"��߳�a-��n�?���d���>~�&ޠ]�}�3������t���~������+?�ȹ~�� ���Uu3e����dɒ� ���k�l�*~`�Ll#�7n#'^X�Ґn�z��Q��7�-�i߯e� _��=�i%��.���pӦ�<��O,�rKN�W=�l����w��ƶ��#���|Ua�^��+.1qI���,$�(�� u���%��w������oT����˧̤]��+k��F5p,�ߠ^�����|�d�J�n����rM>�\��4bA{{�O_�g�xX%)��皙*��ى��(���V�\Y��	s�-xߙ4]R�7�Mm����F>�Oc/E(�$Xؽ�e�F��z��B�'A�-u�4X��N9�F�f)��f~W��Y��~Bj�,��yԮ�c���
�ĬXURWٌ蘒PNWTI��c�
�Ru���Bѽb�u�'O��ᒫL���,+��tE�m-ݫ�E��l���}Za���{N���P�Z�ʕ�w}�0m��E	UID�IU��$�=*u��Di�9�@��9�g_K��e5���t��7#C�E��-M0|�mA�:)9oB�v�V�bn�62F�*T�I��U���S,d]gORP�A,��X�W��\,l]l�؅�~�e�������.BkM೨2> �,���	E*�;̮�y�oX��̶��֮4���!@',�ݫa=��G�T#��@v���;��@���| ��Vں�ſׇ�H�>$rG�_Q<�DI�N���c
6˲Pu��� ,2M�Y���_�����Q,
5J�O�ƃ����J���t��������[ikN�K��� u��{�ݸ^sS�\����ZX�W�����{5ne�����=,9���oY��W�^ Pb������|E|�p�d�(�ͫk���s����b��9��K�0wf��R'�r��|���V���Pս,�\|C��	9ש����d&u4��}��w��f��b�q�^������V�)��InA�^ˆ��Aa�'VP�^c�\g��F���g)E?��-"���|�y(W��-�\����|WI����Jm��i��-尭�С�^��O�Z�A�v٨��{�l��>��p����sL�����¿M�2Z�4F�Q?C�hE��P�˧�(�Eh��m�[�1n�|��(��.��_����w)�-g�y�XX�r<�_U3��+b)�>Ϡi�q���R�j9�
omǣ|_Uz�7[%�pY�G
�ےYh��`���Ń;�\���V2��B����
�\�z�p���LI����.���᳞d�=JI��aa�z�-�- ������j-�RSZw�<�6֥^��1�h��:q���)Ԑ1�Z7�޻l� ��G��
��DC��y�qi(�gm��&�+P� r� � kA�K����N[���� 4� �i�S��ײ�8�c�B�����n���v���7r\l�fGy)�N7ّ��o� �i'\��b���nu�B��;�
ׂ���׫%�U�{F����������^�p����G6��`ݧ��P���o��7���+,�X��EL�Vz�C�=V&�i�+f�+�����.���׃��7ɤ����;_���.��<C�`�qIOق����E�2����g�@a��^w�Qwϰ�_�?v.��b�B��Յ�z�Z�G����.�0>� _�����Ǯ8��b�)�L�Fob�`$�
�K�����M?�㨻�[(���y(�+�>"�^�}���1�CxEb���zM^�!eܾ�q�!b����>>�E�\����,l�ɞ�A���&���p�HY5DW�Ͼ��5��$�LQ��3����&��>���t�J�0��o��8 �"=�S@�ѽ�,LWK�ꍄS����.�,Ah�,wA�Y~%�����!����}�Y��*9�����P<�8�5w�F�����	7ء{ŕ��30\u1#�.�V�(�e���;�l�"� ��5͡=��l�<h���z�m]�Il���r�������^�N�)��ᶦJ�V�oUg\�"Ru���?	�5��~�z%�Wc���vػLf�Q?X5,��j ꪊ��P�p>�4N�5����v��B��̫*�y�H�.���O��� �:�KΥ��t-�C���n������5X�у�fC[���Q��	sz&��R��������;���z�&}����usɝ`�^�nAnD��׮]����k��C��+�^r���c!�^��x�9vE�$��Y@^�ǩ����RD�˸�n=�NͶ��`^�|�S�'))qe|r��GM"��"�B?Ϋ�~�}��j����T��$�/�`�71oj��U~�p�K�q�Y��!�-<�k������[�TAr�v��v �bM�I�Yq'��o��j��LJ&I(F+�(�V�.�1%x����+D��`!��C����(���5�W7P�9mRn4Ä�*S�-��2C^�C�(.p8�&���,��T����J/�7w>��zs��+�ǣ~��� �  �n￯c*��l�?Q-��節b���Bōk�����wQ��wb䏬�OZ�.D��~푅Yz�I�䠖�l���T���sA�&f Jyw͹�W.H��%�ӫmt��g�@Fo���r
.8�HI\P��i�]D��x,�P=Nz��A'1΢��A�;` A�8=�.L�>W.D��!M�|���1i(w��h�ʎcs/>W~O� =o�{	��f�S��߄aS��7���ӱi�q��7r�\���Zw�0׸�qz��yG�~>��Ə��c�y`n:a�� pS���<�k���4@k��Q�̪���4� ��vbK��)Г���Gބ[�����!%9����yûi�m�~����-cBR�v�h��(.ȷ@0�\i���Ά��8��B�*{�Y �"���:)�����̞� 0S��V:@S�L��Wq���'�"���<�Kg=M�,�TH�H�-o]��&��������Y��q�j>W�B��w:�J/�"U�R���C��I���_EP�s������kj,�I2�Y�2�#n2�u��%o�#|uŸ<�ۗ_�ϝ���h�1U��A��;-�Ƞ�"j��]�HT�_eAFF5�eG5V�$����v`F%� +WBfoXؐb���s�����y���/���/���~#�X��Lϙ��ﶮ�����q��{&0�Q�I�t���E��V��`6N��Z(�3���.����d&-:<F���@��]����<��|�k��T9��^5�Ew�݋�豿�j)�{�,�����"~�����a��{})o�)�5���:��ȂO������N��W�!'Uam��w���7�.���V�sw��_�M-��0�I�|�U���a0�oq���g^>aS�J�:2��A��|�#sH\W���r�~�_�a�:AG�`�����P�X����c/��`?��^Gb��^O�����A��R�Dq �����޻�㑵@�HJ�����Fh��ҰALU�e^��,����̠
�ې���h:6YP�8��TIGa	:�#�\A�����:��ehEG��:�f7,��0��(
`@�䞀	�4�� ��v��� �wײ���9��� Bk0U�TT0�(��	T�np.R�8u���h�����Ľ�IB����� ��������BL\�\spr�{��%&&l�$?	���D�0�uu�(��\-�/X2�-�I6�)���S%N9��w;�k���0��=�ؾW�;�z(}?�6���~�Zf�|?��Sg����1�W?�-��1�V��L�}?��+�?R�.������ޏ���t���������6X����~rg��ڈ�>g����O���|�~Z}^����O�/R.���}�a9�uR��MR�����W�Ю��8c� ����W��,��ź�_W����o�����1s      �      x���Kj�0���s�Y/��&dQhAĻ�ͤD��PE.�O�ҋ51���]��̧��UV�~1�R��q:���P��ğ��H�[J��=��'|�ȾC���1�#h���R�[e3�j��e����F�����ڵ4��ZM*iF����nЎ���:��	[�9`����
�9n�D�$��er`�?.�WF	9T7�x���}�s���Z�=L�KX1�����K�O�qG؅�'�1��C�{�� (PV�����]Q?�[W         '   x�33�46�2�\�F 6���4�47�\1z\\\ �         �   x�]�M
�0���)��4I3]*�DTt�f�A����G�b�j7~���-\mj,�<�(�����B�؏B�t��*`߶�fgk�L�|]`� �K�I�g�C�r�V~`��e�u�O�����3���N/\�*�
�J�>�!�i�ΠXO��B)��-5p          [   x�32�,�L�44615315�0��44�rus�	rTpqUv2B}<]9���- ��@��:�M��4y�8��x�r�p��qqq ���         ^   x�m˱� ��3`8� �%�	H����P
;ۗ�@����,e\��ud�n(��c��<�OEl�P���H�#wEKM?�@��_]�Y�E)� ���         <   x�37�4202�50�5��42715���43�27B�1�4��4��27F�15�����qqq cQ         #   x�3�tt����26�v�26���=... ���      �   o   x�eͻ�0E�:��	("���]D�ف�1؀��X))]���\on#�2p��!<<xH�9��R�Q�b����S�Z��A���\�Ĺ�;�HB�L�6�����Z��0�      �   S   x��1
�0D�:9Ş@DS��!���y��~:��K5Q�XL����-�}��S�^!��|+6��2�Nd��Yb�S��      	       x��0�4䲰 ����\��Ʀ\1z\\\ 8��      
   2  x�}�;s�@�����r	,�b��
B'�r,,(�_b&3V)N��;s���\��|ޥ�'�a��1-)�i��D2�L������ʾh�"�Fo��S2i}���VsB��2�����C�0O	R�� �i�Ҝ���s�L�V��h��ga��cY�݋�Xg/4V��F��ǽ�t:��?�Se��)S�t>�3���zgl��;2�؏rX���-��@��Ь�O;)xCr��r!�?PMXB9U�����ɷǔ���a��GŅ���UcΩ�?���6*K��*�k�I6u0�� �o5+}�      (   "f   *   x�u�Wr�rR02Ppw�9<�5X��U�p�{�� ��
D      df   $   x�s�	ruwTpqTs�rTuu
rtq� n�      �h       x�I-.I�K�WH,,�T�/VH,�,�/� q��      �h       x�I-.I�K�WH,,�T�/VH,�,�/� q��      �h       x�I-.I�K�WH,,�T�/VH,�,�/� q��      �h   ,   x�K��WH,**�M,R()Mr
K3�Ss�
KS�Rs� ��      i       x��I�M*J�UHIU�I-K,R�W�ɬ�� k��      5i      x�I�+I�K�� �l      @i      x�I�+IU�I-K,R�W�ɬ�� E��      Fi   +   x�I-.I�U�Wp�J�K�W(H,JT���U(�/RHK,�/� ��y      ci      x�I-.I�K�WHIU��/�� 9�<      ii      x�K,NI# H�      yi      x�K,NI,N �q      �i      x�K,NI# H�      �i      x�K,NI��4  0�      �i      x�K,NI,NK�DC6 [�+�      �i      x�K,NI$ n�      �i      x�K,NIDA��  Zv)�      �j   %   x�r�rtqTpqU05Ppw�9<�5�stu� �at      k   /   x�s���WpTpuwR�V05Ppw�9<�5X��U��=�Q ֌
�      !k   K   x���� D�V�0a�8�,��/EN�~�GE���9�<�����w8��h��+�zP�X�_�~����0      "k   I   x����0�U��3��Đ����G����nEُ��k*�f�,����ٜq�#5
\�b�`��S<y      (k   0   x�s���WpTr�rtqTpqU05Ppw�9<�5�stu� ��r      @k   0   x�s���WpTr�rtqTpqU05Ppw�9<�5�stu� ��r      Ak   H   x����0�U��3��Đ����G����nEُ��k*�f�,����ٜg�#5
\��`��(7�      tk   F   x����0�U<;X�%*�v"��!�w�Y�g
���^Q��`6��4���W�$�I���;      �l   &   x����t��Wptsq�u��]\�\<�� ��U      �l   <   x����t��W�uvvrVpU�	�@P�/4���p��f�`נ0����z �P`      �l   N   x�ʱ�0�U~�пd�\�M؉9X���n���U�!����%gS�nmbUB�(s_��7�X&�O�0����          