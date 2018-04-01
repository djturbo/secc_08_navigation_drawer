# Navigation Drawer
Se aprende como trabajar con los menu laterales conocidos en Android como Navigation Drawer.

# Links
https://developer.android.com/training/implementing-navigation/nav-drawer.html?hl=es-419

# Primeros pasos
importar las siguiente dependencias en el gradle del modulo
    compile 'com.android.support:design:26.1.0'
    compile 'com.android.support:support-v4:26.1.0'
    
# Como mostrar el menu lateral
## 1. Mostrar Icono en el ActionBar
    
    Se consigue con estos tres métodos que se llaman en el onCreate
    
    setSupportActionBar(this.toolbar);
    getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);

## 2. Capturar el pulsado del botón de abrir menú
    
    Se abre capturando el evento del tab en el botón de abrir menú, implementando el método 
    onOptionsItemSelected
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    
        boolean res = true;
    
        switch(item.getItemId()){
            case android.R.id.home:
                this.drawerLayout.openDrawer(GravityCompat.START);
                break;
            default:
                res = super.onOptionsItemSelected(item);
    
        }
        return res;
    
    }
    
## 3. Crear Header Layout
    Para maquetaqr el menú lateral, se crea un header layout header_navigation_layout en la carpeta layout de res
        
        <FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
            android:layout_width="match_parent"
            android:layout_height="match_parent">
        
            <ImageView
                android:layout_width="match_parent"
                android:layout_height="200dp"
                android:src="@drawable/bombshell_01"
                android:scaleType="centerCrop"/>
        
            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="Francisco José Arquellada"
                android:textAppearance="@style/TextAppearance.AppCompat.Large"
                android:textColor="#ffff"
                android:textStyle="bold"
                android:layout_gravity="bottom"
                android:layout_marginLeft="10dp"
                android:layout_marginBottom="10dp"/>
        
        </FrameLayout>
        
    En el main_activity, donde está el navigationDrawer, se configura para que use este header layout usando el siguiente atributo:
    
    app:headerLayout="@layout/header_navigation_drawer"
    
## 3. Menu para el navigation Drawer
    Para que el navigation drawer pinte un menú, se tiene que crear un menu layout, por ejemplo nav_options, en el que se pondrán las entradas de menú que se necesiten, por ejemplo:
    <menu xmlns:android="http://schemas.android.com/apk/res/android">
        <group
            android:checkableBehavior="single">
            <item android:id="@+id/item_mail" android:icon="@android:drawable/ic_dialog_email"
                android:title="Mail" />
            <item android:id="@+id/item_a" android:icon="@android:drawable/ic_dialog_alert"
                android:title="Alert" />
            <item android:id="@+id/item_mail" android:icon="@android:drawable/ic_dialog_info"
                android:title="Info" />
        </group>
    
        <item
            android:title="Otras Opciones">
            <menu>
                <item
                    android:id="@+id/item_opcion_01"
                    android:icon="@android:drawable/ic_dialog_dialer"
                    android:title="Opción 01"/>
                <item
                    android:id="@+id/item_opcion_02"
                    android:icon="@android:drawable/ic_dialog_dialer"
                    android:title="Opcion 02" />
    
            </menu>
        </item>
    </menu>
    
    Para que el menu layout se renderice en el navigation drawer, se usa el atributo 
    app:menu="@menu/nav_menu" 
    
    El resultado final sería:
    
     <android.support.design.widget.NavigationView
                android:id="@+id/navigation_view"
                android:layout_width="wrap_content"
                android:layout_height="match_parent"
                android:layout_gravity="start"
                app:headerLayout="@layout/header_navigation_drawer"
                app:menu="@menu/nav_options"/>