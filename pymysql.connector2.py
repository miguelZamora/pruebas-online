import pandas as pd

# df = pd.DataFrame(datos, columns=["id_cursos_alumno", "alumno_id", "curso_id", "fecha_inscripcion", "estado"])
# df["fecha_inscripcion"] = pd.to_datetime(df["fecha_inscripcion"])

def conectar_mysql():
    return mysql.connector.connect(
        host="localhost", user="root", password="my_root_password", database="db"
    )

def obtener_datos(cursor):
    cursor.execute("SELECT id_cursos_alumno, alumno_id, curso_id, fecha_inscripcion, estado FROM sef_cursos_alumnos")
    return cursor.fetchall()

datos = obtener_datos(cursor)


df = pd.DataFrame(datos, columns=["id_cursos_alumno", "alumno_id", "curso_id", "fecha_inscripcion", "estado"])
df["fecha_inscripcion"] = pd.to_datetime(df["fecha_inscripcion"])



