
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleLongProperty;

public class BatteryInfo
{
    SimpleStringProperty    Present                 = null;
    SimpleLongProperty      DesignCapacity          = null;
    SimpleStringProperty    DesignCapacityUts       = null;
    SimpleLongProperty      LastFullCapacity        = null;
    SimpleStringProperty    LastFullCapacityUts     = null;
    SimpleStringProperty    BatteryTechnology       = null;
    SimpleLongProperty      DesignVoltage           = null;
    SimpleStringProperty    DesignVoltageUts        = null;
    SimpleLongProperty      CapacityWarn            = null;
    SimpleStringProperty    CapacityWarnUts         = null;
    SimpleLongProperty      CapacityLow             = null;
    SimpleStringProperty    CapacityLowUts          = null;
    SimpleLongProperty      CycleCount              = null;
    SimpleLongProperty      FirstGranularity        = null;
    SimpleStringProperty    FirstGranularityUts     = null;
    SimpleLongProperty      SecondGranularity       = null;
    SimpleStringProperty    SecondGranularityUts    = null;
    SimpleStringProperty    ModelNumber             = null;
    SimpleStringProperty    SerialNumber            = null;
    SimpleStringProperty    BatteryType             = null;
    SimpleStringProperty    Manufacturer            = null;
    
    public BatteryInfo()
    {
        Present                 = new SimpleStringProperty();
        DesignCapacity          = new SimpleLongProperty();
        DesignCapacityUts       = new SimpleStringProperty();
        LastFullCapacity        = new SimpleLongProperty();
        LastFullCapacityUts     = new SimpleStringProperty();
        BatteryTechnology       = new SimpleStringProperty();
        DesignVoltage           = new SimpleLongProperty();
        DesignVoltageUts        = new SimpleStringProperty();
        CapacityWarn            = new SimpleLongProperty();
        CapacityWarnUts         = new SimpleStringProperty();
        CapacityLow             = new SimpleLongProperty();
        CapacityLowUts          = new SimpleStringProperty();
        CycleCount              = new SimpleLongProperty();
        FirstGranularity        = new SimpleLongProperty();
        FirstGranularityUts     = new SimpleStringProperty();
        SecondGranularity       = new SimpleLongProperty();
        SecondGranularityUts    = new SimpleStringProperty();
        ModelNumber             = new SimpleStringProperty();
        SerialNumber            = new SimpleStringProperty();
        BatteryType             = new SimpleStringProperty();
        Manufacturer            = new SimpleStringProperty();
    }
    
    public void update( String contents )
    {
        String[] lines = contents.split( "\\n" );
        for( String line : lines )
        {
            String[] tokens = line.split( ":\\s+" );
            
            if( tokens[0].equals( "present" ) )
            {
                if( tokens.length > 1 )
                {
                    Present.setValue( tokens[1] );
                }
            }
            else if( tokens[0].equals( "design capacity" ) )
            {
                if( tokens.length > 1 )
                {
                    String[] values = tokens[1].split( "\\s+" );
                    DesignCapacity.setValue( Long.parseLong( values[0] ) );
                    DesignCapacityUts.setValue( values[1] );
                }
            }
            else if( tokens[0].equals( "last full capacity" ) )
            {
                if( tokens.length > 1 )
                {
                    String[] values = tokens[1].split( "\\s+" );
                    LastFullCapacity.setValue( Long.parseLong( values[0] ) );
                    LastFullCapacityUts.setValue( values[1] );
                }
            }
            else if( tokens[0].equals( "battery technology" ) )
            {
                if( tokens.length > 1 )
                {
                    BatteryTechnology.setValue( tokens[1] );
                }
            }
            else if( tokens[0].equals( "design voltage" ) )
            {
                if( tokens.length > 1 )
                {
                    String[] values = tokens[1].split( "\\s+" );
                    DesignVoltage.setValue( Long.parseLong( values[0] ) );
                    DesignVoltageUts.setValue( values[1] );
                }
            }
            else if( tokens[0].equals( "design capacity warning" ) )
            {
                if( tokens.length > 1 )
                {
                    String[] values = tokens[1].split( "\\s+" );
                    CapacityWarn.setValue( Long.parseLong( values[0] ) );
                    CapacityWarnUts.setValue( values[1] );
                }
            }
            else if( tokens[0].equals( "design capacity low" ) )
            {
                if( tokens.length > 1 )
                {
                    String[] values = tokens[1].split( "\\s+" );
                    CapacityLow.setValue( Long.parseLong( values[0] ) );
                    CapacityLowUts.setValue( values[1] );
                }
            }
            else if( tokens[0].equals( "cycle count" ) )
            {
                if( tokens.length > 1 )
                {
                    CycleCount.setValue( Long.parseLong( tokens[1] ) );
                }
            }
            else if( tokens[0].equals( "capacity granularity 1" ) )
            {
                if( tokens.length > 1 )
                {
                    String[] values = tokens[1].split( "\\s+" );
                    FirstGranularity.setValue( Long.parseLong( values[0] ) );
                    FirstGranularityUts.setValue( values[1] );
                }
            }
            else if( tokens[0].equals( "capacity granularity 2" ) )
            {
                if( tokens.length > 1 )
                {
                    String[] values = tokens[1].split( "\\s+" );
                    SecondGranularity.setValue( Long.parseLong( values[0] ) );
                    SecondGranularityUts.setValue( values[1] );
                }
            }
            else if( tokens[0].equals( "model number" ) )
            {
                if( tokens.length > 1 )
                {
                    ModelNumber.setValue( tokens[1] );
                }
            }
            else if( tokens[0].equals( "serial number" ) )
            {
                if( tokens.length > 1 )
                {
                    SerialNumber.setValue( tokens[1] );
                }
            }
            else if( tokens[0].equals( "battery type" ) )
            {
                if( tokens.length > 1 )
                {
                    BatteryType.setValue( tokens[1] );
                }
            }
            else if( tokens[0].equals( "OEM info" ) )
            {
                if( tokens.length > 1 )
                {
                    Manufacturer.setValue( tokens[1] );
                }
            }
        }
    }
    
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        
        builder.append( Present.getValue() );
        builder.append( "  " );
        builder.append( DesignCapacity.getValue() );
        builder.append( " " );
        builder.append( DesignCapacityUts.getValue() );
        builder.append( "  " );
        builder.append( LastFullCapacity.getValue() );
        builder.append( " " );
        builder.append( LastFullCapacityUts.getValue() );
        builder.append( "  " );
        builder.append( BatteryTechnology.getValue() );
        builder.append( "  " );
        builder.append( DesignVoltage.getValue() );
        builder.append( " " );
        builder.append( DesignVoltageUts.getValue() );
        builder.append( "  " );
        builder.append( CapacityWarn.getValue() );
        builder.append( " " );
        builder.append( CapacityWarnUts.getValue() );
        builder.append( "  " );
        builder.append( CapacityLow.getValue() );
        builder.append( " " );
        builder.append( CapacityLowUts.getValue() );
        builder.append( "  " );
        builder.append( CycleCount.getValue() );
        builder.append( "  " );
        builder.append( FirstGranularity.getValue() );
        builder.append( " " );
        builder.append( FirstGranularityUts.getValue() );
        builder.append( "  " );
        builder.append( SecondGranularity.getValue() );
        builder.append( " " );
        builder.append( SecondGranularityUts.getValue() );
        builder.append( "  " );
        builder.append( ModelNumber.getValue() );
        builder.append( "  " );
        builder.append( SerialNumber.getValue() );
        builder.append( "  " );
        builder.append( BatteryType.getValue() );
        builder.append( "  " );
        builder.append( Manufacturer.getValue() );
        builder.append( "  " );
        
        return builder.toString();
    }
}
