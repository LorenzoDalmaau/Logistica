package org.example;

import java.io.File;
import java.nio.file.Files;
import java.util.concurrent.Delayed;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final String ARCHIVO_ENTRADA = "datos/envios_entrada.csv";
    private static final String ARCHIVO_VALIDOS = "datos/envios_validos.csv";
    private static final String ARCHIVO_ERRORES = "datos/errores.log";
    // Ruta del archivo de texto con el resumen de kilos
    private static final String ARCHIVO_RESUMEN = "datos/resumen_kilos.txt";
    // Nombre de la carpeta donde moveremos el archivo una vez procesado
    private static final String CARPETA_PROCESADOS = "datos/procesados";
    ///  Caracter separador del CSV. En este proyecto usaremos ";" en vez de ","
    private static final String SEPARADOR = ";";


    static void main() {
        System.out.println("=================================================");
        System.out.println("  Sistema de Procesamiento - Logística Global S.A.");
        System.out.println("=================================================");


        procesarArchivo();
    }

    /// MÉTODO PRINCIPAL DE PROCESAMIENTO
    private static void procesarArchivo() {
        /// 1. Verificamos que existe la estructura de carpetas
        /// La clase File nos permite trabajar con rutas del sistema de archivos
        ///  sin aún abrir ningún archivo.
        verificarEstructuraCarpetas();

        ///
        File archivoEntrada = new File(ARCHIVO_ENTRADA);

        if (!archivoEntrada.exists()) {
            System.out.println("ERROR: Archivo no encontrado ->" + ARCHIVO_ENTRADA);
            System.out.println("Por favor, coloque el archivo en la carpeta 'datos/'");
        }

        System.out.println("Archivo de entrada encontrada: " + ARCHIVO_ENTRADA);
        System.out.println("Iniciando procesamiento...\n");
    }


    private static void verificarEstructuraCarpetas() {
        /// IMPORTANTE: FIle solo representa la RUTA, no abre ni crea nada todavía
        File carpetaDatos = new File("datos");

        if (!carpetaDatos.exists() || !carpetaDatos.isDirectory()) {
            boolean creada = carpetaDatos.mkdir();

            if (creada) {
                System.out.println("Carpeta 'datos/' creada automaticamente.");
            } else {
                System.err.println("ADVERTENCIA: No se pudo crear la carpeta 'datos/'");
            }
        }
    }
}
