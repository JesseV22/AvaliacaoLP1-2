# AvaliacaoLP1-2
AvaliacaoLP1-2




Entidades:

Curso

Atributos: id (chave primária), carga_cur, nome_cur, descri_cur.
Aluno

Atributos: id (chave primária), nome_al, email_al, data_al, tel_al.
Professor

Atributos: id (chave primária), nome_prof, email_prof, end_prof, tel_prof, especialidade.
Relacionamentos:

Relacionamento 1-N entre Aluno e Matricula:

A tabela Matricula possui a chave estrangeira AlunoID, que referencia a chave primária id na tabela Aluno.
Isso significa que um aluno pode ter várias matrículas, enquanto uma matrícula pertence a apenas um aluno.
Relacionamento 1-N entre Curso e Matricula:

A tabela Matricula possui a chave estrangeira CursoID, que referencia a chave primária id na tabela Curso.
Isso significa que um curso pode ter várias matrículas, enquanto uma matrícula pertence a apenas um curso.
Relacionamento N-N entre Aluno e Curso através da tabela Matricula:

A tabela Matricula atua como uma tabela de associação que conecta as tabelas Aluno e Curso.
Ela possui as chaves estrangeiras AlunoID e CursoID, que referenciam as chaves primárias id nas tabelas Aluno e Curso, respectivamente.
Isso permite que um aluno esteja matriculado em vários cursos e que um curso tenha vários alunos matriculados.
