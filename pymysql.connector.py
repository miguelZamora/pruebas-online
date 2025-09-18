import mysql.connector
import matplotlib.pyplot as plt
from collections import Counter


# Conexión a MySQL
# conn = mysql.connector.connect(
#     host="localhost", user="root", password="my_root_password", database="db"
# )
# cursor = conn.cursor()
# cursor.execute("SELECT id_cursos_alumno, alumno_id, curso_id, fecha_inscripcion, estado FROM sef_cursos_alumnos")
# datos = cursor.fetchall()

def conectar_mysql():
    return mysql.connector.connect(
        host="localhost", user="root", password="my_root_password", database="db"
    )

def obtener_datos(cursor):
    cursor.execute("SELECT id_cursos_alumno, alumno_id, curso_id, fecha_inscripcion, estado FROM sef_cursos_alumnos")
    return cursor.fetchall()
 
def get_datos_mysql(datos):


    id_cursos_alumno    = [fila[0] for fila in datos] 
    alumno_id           = [fila[1] for fila in datos] 
    curso_id            = [fila[2] for fila in datos] 
    fecha_inscripcion   = [fila[3] for fila in datos] 
    estado              = [fila[4] for fila in datos] 

    # Cantidad de alumnos por estado
    # get_datos_mysql(datos)

    conteo_estado = Counter(estado)
    plt.bar(conteo_estado.keys(), conteo_estado.values())
    plt.title("Cantidad de alumnos por estado")
    plt.xlabel("Estado")
    plt.ylabel("Cantidad")
    plt.show()


    # Inscripciones por fecha
    fechas = [f.strftime("%Y-%m-%d") for f in fecha_inscripcion]
    conteo_fechas = Counter(fechas)
    fechas_ordenadas = sorted(conteo_fechas.items())

    x = [f[0] for f in fechas_ordenadas]
    y = [f[1] for f in fechas_ordenadas]


    plt.plot(x, y, marker='o')
    plt.xticks(rotation=45)
    plt.title("Inscripciones por fecha")
    plt.xlabel("Fecha")
    plt.ylabel("Cantidad")
    plt.tight_layout()
    plt.show()


    # Alumnos por curso

    conteo_curso = Counter(curso_id)
    plt.bar(conteo_curso.keys(), conteo_curso.values())
    plt.title("Cantidad de alumnos por curso")
    plt.xlabel("ID Curso")
    plt.ylabel("Cantidad")
    plt.show()
    return datos



if __name__ == "__main__":
    datos = get_datos_mysql()
    print(f"Total registros: {len(datos)}")
    print("Primeros 5 registros:")
    for fila in datos[:5]:
        print(fila)
    

    # id_cursos_alumno categorias, alumno_id, curso_id, fecha_inscripcion, estado