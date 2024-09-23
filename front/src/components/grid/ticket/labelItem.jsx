const EtiquetaConLinea = ({ label, content, color, colorContent }) => {
    const fontStyle = {
        fontFamily: 'Poppins, sans-serif',
        fontSize: '1.2em',
        display: 'block',
        color: color
    };
    const contentStyle = {
        fontFamily: 'Poppins, sans-serif',
        fontSize: '1.2em',
        display: 'block',
        color: colorContent
    };
  return (
    <div style={{ textAlign: 'left' }}>
      <label style={fontStyle}>{label}</label>
      <label style={contentStyle}>{content}</label>
      <div style={{ width: '100%', height: '2px', backgroundColor: 'pink', marginTop: '5px' }} />
    </div>
  );
};

export default EtiquetaConLinea;
